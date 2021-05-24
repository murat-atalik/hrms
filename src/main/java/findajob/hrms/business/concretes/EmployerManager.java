package findajob.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.EmployerService;
import findajob.hrms.core.utilities.DataResult;
import findajob.hrms.core.utilities.Result;
import findajob.hrms.core.utilities.SuccessDataResult;
import findajob.hrms.core.utilities.SuccessResult;
import findajob.hrms.dataAccess.abstracts.EmployerDao;
import findajob.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		this.employerDao=employerDao;
	}
	@Override
	public Result add(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult("Employer Added");
		
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Employer Listed");
	}

}
