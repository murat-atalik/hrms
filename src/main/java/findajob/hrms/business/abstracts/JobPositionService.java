package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.JobPosition;

public interface JobPositionService {

	Result add(JobPosition jobPosition);

	Result update(JobPosition jobPosition);

	DataResult<List<JobPosition>> getAll();

	DataResult<JobPosition> getById(int id);

}
