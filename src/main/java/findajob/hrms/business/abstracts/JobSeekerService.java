package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	void add(JobSeeker jobSeeker);
	List<JobSeeker> getAll();

}
