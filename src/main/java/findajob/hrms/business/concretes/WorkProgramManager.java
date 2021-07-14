package findajob.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.WorkProgramService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.core.utilities.results.SuccessDataResult;
import findajob.hrms.core.utilities.results.SuccessResult;
import findajob.hrms.dataAccess.abstracts.WorkProgramDao;
import findajob.hrms.entities.concretes.WorkProgram;

@Service
public class WorkProgramManager implements WorkProgramService {

	private WorkProgramDao workProgramDao;

	@Autowired
	public WorkProgramManager(WorkProgramDao workProgramDao) {
		super();
		this.workProgramDao = workProgramDao;
	}

	@Override
	public Result add(WorkProgram workProgram) {
		this.workProgramDao.save(workProgram);

		return new SuccessResult("Work Program eklendi");
	}

	@Override
	public DataResult<List<WorkProgram>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<WorkProgram>>(this.workProgramDao.findAll());
	}

	@Override
	public DataResult<WorkProgram> getById(int id) {		
		return new SuccessDataResult<WorkProgram>(this.workProgramDao.getOne(id));
	}

	@Override
	public Result update(WorkProgram workProgram) {
		this.workProgramDao.save(workProgram);
		return new SuccessResult("Çalışma Programı Güncellendi");
	}

}
