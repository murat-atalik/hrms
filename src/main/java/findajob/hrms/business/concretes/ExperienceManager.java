package findajob.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.ExperienceService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.core.utilities.results.SuccessDataResult;
import findajob.hrms.core.utilities.results.SuccessResult;
import findajob.hrms.dataAccess.abstracts.ExperienceDao;
import findajob.hrms.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService {
	private ExperienceDao experienceDao;

	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public Result add(Experience experience) {
		this.experienceDao.save(experience);
		return new SuccessResult("experience added");
	}

	@Override
	public DataResult<List<Experience>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll(),"listed");
	}

	@Override
	public Result delete(int id) {
		this.experienceDao.deleteById(id);
		return new SuccessResult("Çalışma deneyimi silindi");
	}

	@Override
	public boolean existsById(int id) {
		// TODO Auto-generated method stub
		return this.experienceDao.existsById(id);
	}
	
}
