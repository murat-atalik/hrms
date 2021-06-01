package findajob.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.CandidateService;
import findajob.hrms.core.adapters.FakeCheck;
import findajob.hrms.core.adapters.MernisServiceAdapter;
import findajob.hrms.core.adapters.UserCheckService;
import findajob.hrms.core.helpers.BusinessRules;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.ErrorResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.core.utilities.results.SuccessDataResult;
import findajob.hrms.core.utilities.results.SuccessResult;
import findajob.hrms.dataAccess.abstracts.CandidateDao;
import findajob.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserCheckService userCheckService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, FakeCheck userCheckService) {
		this.candidateDao = candidateDao;
		this.userCheckService = userCheckService;
	}

	// TODO: Refactor this code block
	@Override
	public Result add(Candidate candidate) {

		// this code block changes after learn
		/*
		 * if (!findByNationalityId(jobSeeker.getNationalityId()).isSuccess()) { return
		 * findByNationalityId(jobSeeker.getNationalityId()); } else if
		 * (!findByEmail(jobSeeker.getEmail()).isSuccess()) { return
		 * findByEmail(jobSeeker.getEmail()); } else if
		 * (!this.JobSeekerCheck(jobSeeker).isSuccess()) { return
		 * this.JobSeekerCheck(jobSeeker); } else if
		 * (!this.PasswordCheck(jobSeeker).isSuccess()) { return
		 * this.PasswordCheck(jobSeeker); } else if
		 * (this.userCheckService.CheckIfRealPerson(jobSeeker.getNationalityId(),
		 * jobSeeker.getFirstName(), jobSeeker.getLastName(),
		 * jobSeeker.getBirthday()).isSuccess()) { return new
		 * ErrorResult("Invalid User"); } else if
		 * (!emailVerification(jobSeeker.getEmail()).isSuccess()) { return
		 * emailVerification(jobSeeker.getEmail()); }
		 */
		Result error = BusinessRules
				.Run(findByNationalityId(candidate.getNationalityId()), findByEmail(candidate.getEmail()),
						this.CandidateCheck(candidate), this.PasswordCheck(candidate),
						this.userCheckService.CheckIfRealPerson(candidate.getNationalityId(), candidate.getFirstName(),
								candidate.getLastName(), candidate.getBirthday()),
						emailVerification(candidate.getEmail()));
		if (error.isSuccess()) {
			this.candidateDao.save(candidate);
			return new SuccessResult("JobSeeker added");
		}
		return error;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Job seekers listed");
	}

	private Result CandidateCheck(Candidate jS) {
		if (jS.getPassword().strip().isEmpty() || jS.getBirthday().toString().isEmpty()
				|| jS.getFirstName().strip().isEmpty() || jS.getLastName().strip().isEmpty()
				|| jS.getNationalityId().strip().isEmpty() || jS.getEmail().strip().isEmpty()) {
			return new ErrorResult("All fields required");
		}

		return new SuccessResult();
	}

	private Result findByNationalityId(String nationalityId) {
		if (this.candidateDao.existsCandidateByNationalityId(nationalityId)) {
			return new ErrorResult("NationalityId already exists");
		}
		return new SuccessResult();
	}

	private Result findByEmail(String email) {
		if (this.candidateDao.existsCandidateByEmail(email)) {
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

	private Result PasswordCheck(Candidate candidate) {
		if (candidate.getPassword().equals(candidate.getRePassword())) {
			return new SuccessResult();
		}
		return new ErrorResult("Password & RePassword must same");
	}
}
