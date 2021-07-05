package findajob.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.AbilityService;
import findajob.hrms.business.abstracts.CurriculumVitaeService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.core.utilities.results.SuccessDataResult;
import findajob.hrms.core.utilities.results.SuccessResult;
import findajob.hrms.dataAccess.abstracts.AbilityDao;
import findajob.hrms.entities.concretes.Ability;


@Service
public class AbilityManager implements AbilityService {

	private AbilityDao abilityDao;

	@Autowired
	public AbilityManager(AbilityDao abilityDao) {
		super();
		this.abilityDao = abilityDao;
		
	}

	@Override
	public Result add(Ability ability) {
		this.abilityDao.save(ability);
		return new SuccessResult("ability added");
	}

	@Override
	public DataResult<List<Ability>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Ability>>(this.abilityDao.findAll(), "abilities listed");
	}

	@Override
	public Result delete(int id) {
		this.abilityDao.deleteById(id);
		return new SuccessResult("Yetenek silindi!");
	}

	@Override
	public boolean existsById(int id) {
		// TODO Auto-generated method stub
		return this.abilityDao.existsById(id);
	}

	@Override
	public Result update(Ability ability) {

		this.abilityDao.save(ability);

		return null;
	}

}
