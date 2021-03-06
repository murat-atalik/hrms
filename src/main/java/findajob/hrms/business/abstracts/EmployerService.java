package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.Employer;
import findajob.hrms.entities.dtos.request.EmployerAddDto;
import findajob.hrms.entities.dtos.request.EmployerUpdateDto;

public interface EmployerService {
	Result add(EmployerAddDto employer);

	Result delete(int id);

	Result update(EmployerUpdateDto employer);

	DataResult<List<Employer>> getAll();

	DataResult<List<Employer>> getUnConfirmed();

	DataResult<Employer> getById(int id);

	DataResult<Employer> changeConfirmStatus(int id);
}
