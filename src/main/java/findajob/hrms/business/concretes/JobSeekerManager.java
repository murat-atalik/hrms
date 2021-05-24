package findajob.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.JobSeekerService;
import findajob.hrms.dataAccess.abstracts.JobSeekerDao;
import findajob.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		this.jobSeekerDao=jobSeekerDao;
	}
	@Override
	public void add(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		
	}
	@Override
	public List<JobSeeker> getAll() {
		// TODO Auto-generated method stub
		return this.jobSeekerDao.findAll();
	}
	
}
