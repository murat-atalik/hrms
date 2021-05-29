package findajob.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.CompanyService;
import findajob.hrms.core.utilities.DataResult;
import findajob.hrms.core.utilities.Result;
import findajob.hrms.core.utilities.SuccessDataResult;
import findajob.hrms.core.utilities.SuccessResult;
import findajob.hrms.dataAccess.abstracts.CompanyDao;
import findajob.hrms.entities.concretes.Company;

@Service
public class CompanyManager implements CompanyService {

	private CompanyDao companyDao;
	@Autowired
	public CompanyManager(CompanyDao companyDao) {
		this.companyDao=companyDao;
	}
	
	@Override
	public Result Add(Company company) {
		this.companyDao.save(company);
		return new SuccessResult("Company Added");
			
	}

	@Override
	public DataResult<Company> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Company>(this.companyDao.getOne(id),"Company Listed");
	}

	@Override
	public DataResult<List<Company>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Company>>(this.companyDao.findAll(),"Companies Listed");
	}

}
