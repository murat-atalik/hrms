package findajob.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.CompanyService;
import findajob.hrms.business.abstracts.UpdatedCompanyService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.ErrorResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.core.utilities.results.SuccessDataResult;
import findajob.hrms.core.utilities.results.SuccessResult;
import findajob.hrms.dataAccess.abstracts.UpdatedCompanyDao;
import findajob.hrms.entities.concretes.Company;
import findajob.hrms.entities.concretes.UpdatedCompany;

@Service
public class UpdatedCompanyManager implements UpdatedCompanyService{
	private UpdatedCompanyDao updatedCompanyDao;
	private CompanyService companyService;
	@Autowired
	public UpdatedCompanyManager(UpdatedCompanyDao updatedCompanyDao, CompanyService companyService) {
		super();
		this.updatedCompanyDao = updatedCompanyDao;
		 this.companyService = companyService;
	}


	@Override
	public Result add(UpdatedCompany updatedCompany) {
		updatedCompany.setWaitingUpdate(true);
		
		Company company = new Company();
		company = this.companyService.getById(updatedCompany.getCompanyId()).getData();
		
		if(!company.isWaitingUpdate()) {
			return new ErrorResult("Lütfen önceki güncellemeyi iptal edin");
		}
		company.setWaitingUpdate(true);
		this.companyService.update(company);
		this.updatedCompanyDao.save(updatedCompany);
		return new SuccessResult("Şirekt bilgileri güncellendi");
	}


	@Override
	public Result update(int id) {
		UpdatedCompany updatedCompany =new UpdatedCompany();
		updatedCompany= this.updatedCompanyDao.getById(id);
		 Company company = new Company();
		 company.setId(updatedCompany.getCompanyId());
		 company.setCompanyName(updatedCompany.getCompanyName());
		 company.setWebAddress(updatedCompany.getWebAddress());
		 company.setWaitingUpdate(false);
		if(this.companyService.update(company).isSuccess()) {
			this.updatedCompanyDao.delete(updatedCompany);
		}
		
		return new SuccessResult("Şirekt bilgileri güncellendi");
	}

	@Override
	public Result delete(int id) {
		UpdatedCompany updatedCompany =new UpdatedCompany();
		updatedCompany= this.updatedCompanyDao.getById(id);
		 Company company = new Company();
		 company=this.companyService.getById(updatedCompany.getCompanyId()).getData();
		 company.setWaitingUpdate(false);
		 this.companyService.update(company);
		this.updatedCompanyDao.deleteById(id);
		return new SuccessResult("Şirekt güncelleme bilgileri silindi");
	}

	@Override
	public DataResult<List<UpdatedCompany>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<UpdatedCompany>>(this.updatedCompanyDao.findAll());
	}

	@Override
	public DataResult<UpdatedCompany> getByEmployerId(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<UpdatedCompany>(this.updatedCompanyDao.getByEmployerId(id));
	}

	@Override
	public DataResult<UpdatedCompany> getByCompanyId(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<UpdatedCompany>(this.updatedCompanyDao.getByCompanyId(id));
	}

}
