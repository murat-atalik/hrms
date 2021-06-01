package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.Company;

public interface CompanyService {
	Result Add(Company company);
	DataResult<Company> getById(int id);
	DataResult<List<Company>> getAll();
	
}
