package findajob.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.CompanyService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.core.utilities.results.SuccessDataResult;
import findajob.hrms.core.utilities.results.SuccessResult;
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
	public Result add(Company company) {
		this.companyDao.save(company);
		company.setWaitingUpdate(false);
		return new SuccessResult("Company Added");
			
	}
	@Override
	public Result update(Company company) {
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

	@Override
	public DataResult<Company> getByCompanyName(String companyName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Company>(this.companyDao.getByCompanyName(companyName));
	}

	@Override
	public DataResult<Company> getByWebAdress(String webAdress) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Company>(this.companyDao.getByWebAddress(webAdress));
	}

}
