package findajob.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.TypeOfWorkService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.core.utilities.results.SuccessDataResult;
import findajob.hrms.core.utilities.results.SuccessResult;
import findajob.hrms.dataAccess.abstracts.TypeOfWorkDao;
import findajob.hrms.entities.concretes.TypeOfWork;
@Service
public class TypeOfWorkManager implements TypeOfWorkService{

	private TypeOfWorkDao typeOfWorkDao;
	
	@Autowired
	public TypeOfWorkManager(TypeOfWorkDao typeOfWorkDao) {
		super();
		this.typeOfWorkDao = typeOfWorkDao;
	}

	@Override
	public Result add(TypeOfWork typeOfWork) {
		this.typeOfWorkDao.save(typeOfWork);
		return new SuccessResult("Saved");
	}

	@Override
	public DataResult<List<TypeOfWork>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<TypeOfWork>>(this.typeOfWorkDao.findAll(),"Saved");
	}

	@Override
	public DataResult<TypeOfWork> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<TypeOfWork>(this.typeOfWorkDao.getOne(id),"get by id");
	}

}
