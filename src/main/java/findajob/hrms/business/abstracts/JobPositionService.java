package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.core.utilities.DataResult;
import findajob.hrms.core.utilities.Result;
import findajob.hrms.entities.concretes.JobPosition;

public interface JobPositionService {

	Result add(JobPosition jobPosition);
	DataResult<List<JobPosition>> getAll();

}
