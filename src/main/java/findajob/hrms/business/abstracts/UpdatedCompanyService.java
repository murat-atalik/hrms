package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.UpdatedCompany;

public interface UpdatedCompanyService {
	Result add(UpdatedCompany updatedCompany);
	Result update(int id);
	Result delete(int id);
	DataResult<List<UpdatedCompany>> getAll();
	DataResult<UpdatedCompany> getByEmployerId(int id);
	DataResult<UpdatedCompany> getByCompanyId(int id);
}
