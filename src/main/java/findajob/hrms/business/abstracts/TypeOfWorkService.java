package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.TypeOfWork;

public interface TypeOfWorkService {
	Result add(TypeOfWork typeOfWork);
	DataResult<List<TypeOfWork>> getAll();
	DataResult<TypeOfWork> getById(int id);
}
