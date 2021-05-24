package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.core.utilities.DataResult;
import findajob.hrms.core.utilities.Result;
import findajob.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	Result add(JobSeeker jobSeeker);
	DataResult<List<JobSeeker>> getAll();

}
