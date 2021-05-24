package findajob.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.JobSeekerService;
import findajob.hrms.business.abstracts.UserCheckService;
import findajob.hrms.core.adapters.FakeCheck;
import findajob.hrms.core.adapters.MernisServiceAdapter;
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

	@Override
	public Result add(JobSeeker jobSeeker) {
		if (this.JobSeekerCheck(jobSeeker)&&jobSeeker.getPassword().equals(jobSeeker.getRePassword())) {
			if (this.userCheckService.CheckIfRealPerson(jobSeeker.getNationalityId(), jobSeeker.getFirstName(),
					jobSeeker.getLastName(), jobSeeker.getBirthday())) {
				this.jobSeekerDao.save(jobSeeker);
				return new SuccessResult("JobSeeker added");
			}
			return new ErrorResult("All fields required");
			
		}
		return new ErrorResult("Register error");

	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"Job seekers listed");
	}

	private boolean JobSeekerCheck(JobSeeker jS) {
		if (jS.getPassword().strip().isEmpty() || jS.getBirthday().toString().isEmpty()
				|| jS.getFirstName().strip().isEmpty() || jS.getLastName().strip().isEmpty()
				|| jS.getNationalityId().strip().isEmpty() || jS.getEmail().strip().isEmpty()) {
			return false;
		}

		return true;
	}
}
