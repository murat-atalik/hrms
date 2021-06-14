package findajob.hrms.business.abstracts;

import java.util.List;


import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.WorkProgram;

public interface WorkProgramService {
	Result add(WorkProgram workProgram);
	DataResult<List<WorkProgram>> getAll();
	DataResult<WorkProgram> getById(int id);
}
