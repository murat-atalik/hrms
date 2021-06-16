package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.WorkType;

public interface WorkTypeService {
	Result add(WorkType typeOfWork);
	DataResult<List<WorkType>> getAll();
	DataResult<WorkType> getById(int id);
}
