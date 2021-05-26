package findajob.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.JobSeekerService;
import findajob.hrms.core.adapters.FakeCheck;
import findajob.hrms.core.adapters.MernisServiceAdapter;
import findajob.hrms.core.adapters.UserCheckService;
import findajob.hrms.core.utilities.DataResult;
import findajob.hrms.core.utilities.ErrorResult;
import findajob.hrms.core.utilities.Result;
import findajob.hrms.core.utilities.SuccessDataResult;
import findajob.hrms.core.utilities.SuccessResult;
import findajob.hrms.dataAccess.abstracts.JobSeekerDao;
import findajob.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private UserCheckService userCheckService;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, FakeCheck userCheckService) {
		this.jobSeekerDao = jobSeekerDao;
		this.userCheckService = userCheckService;
	}

	// TODO: Refactor this code block
	@Override
	public Result add(JobSeeker jobSeeker) {
		if (!findByNationalityId(jobSeeker.getNationalityId()).isSuccess()) {
			return findByNationalityId(jobSeeker.getNationalityId());
		} else if (!findByEmail(jobSeeker.getEmail()).isSuccess()) {
			return findByEmail(jobSeeker.getEmail());
		} else if (!this.JobSeekerCheck(jobSeeker).isSuccess()) {
			return this.JobSeekerCheck(jobSeeker);
		} else if (!this.PasswordCheck(jobSeeker).isSuccess()) {
			return this.PasswordCheck(jobSeeker);
		} else if (this.userCheckService.CheckIfRealPerson(jobSeeker.getNationalityId(), jobSeeker.getFirstName(),
				jobSeeker.getLastName(), jobSeeker.getBirthday()).isSuccess()) {
			return new ErrorResult("Invalid User");
		} else if (!emailVerification(jobSeeker.getEmail()).isSuccess()) {
			return emailVerification(jobSeeker.getEmail());
		}
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("JobSeeker added");
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "Job seekers listed");
	}

	private Result JobSeekerCheck(JobSeeker jS) {
		if (jS.getPassword().strip().isEmpty() || jS.getBirthday().toString().isEmpty()
				|| jS.getFirstName().strip().isEmpty() || jS.getLastName().strip().isEmpty()
				|| jS.getNationalityId().strip().isEmpty() || jS.getEmail().strip().isEmpty()) {
			return new ErrorResult("All fields required");
		}

		return new SuccessResult();
	}

	private Result findByNationalityId(String nationalityId) {
		if (this.jobSeekerDao.existsJobSeekerByNationalityId(nationalityId)) {
			return new ErrorResult("Invalid nationality number");
		}
		return new SuccessResult();
	}

	private Result findByEmail(String email) {
		if (this.jobSeekerDao.existsJobSeekerByEmail(email)) {
			return new ErrorResult("Job Seeker have already account");
		}
		return new SuccessResult();
	}

	// Fake email verification
	private Result emailVerification(String email) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			return new SuccessResult();
		}
		return new ErrorResult("Email verification fail");
	}

	private Result PasswordCheck(JobSeeker jobSeeker) {
		if (jobSeeker.getPassword().equals(jobSeeker.getRePassword())) {
			return new SuccessResult();
		}
		return new ErrorResult("Password & RePassword must same");
	}
}
