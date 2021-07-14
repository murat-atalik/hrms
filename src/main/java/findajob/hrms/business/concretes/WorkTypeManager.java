package findajob.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import findajob.hrms.business.abstracts.WorkTypeService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.core.utilities.results.SuccessDataResult;
import findajob.hrms.core.utilities.results.SuccessResult;

import findajob.hrms.dataAccess.abstracts.WorkTypeDao;

import findajob.hrms.entities.concretes.WorkType;
@Service
public class WorkTypeManager implements WorkTypeService{

	private WorkTypeDao workTypeDao;
	
	@Autowired
	public WorkTypeManager(WorkTypeDao workTypeDao) {
		super();
		this.workTypeDao = workTypeDao;
	}

	@Override
	public Result add(WorkType workType) {
		this.workTypeDao.save(workType);
		return new SuccessResult("Saved");
	}

	@Override
	public DataResult<List<WorkType>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<WorkType>>(this.workTypeDao.findAll(),"Saved");
	}

	@Override
	public DataResult<WorkType> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<WorkType>(this.workTypeDao.getOne(id),"get by id");
	}

	@Override
	public Result update(WorkType workType) {
		this.workTypeDao.save(workType);
		return new SuccessResult("Güncellendi");
	}

}
