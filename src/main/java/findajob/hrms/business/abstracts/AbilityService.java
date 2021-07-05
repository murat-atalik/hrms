package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.Ability;
import findajob.hrms.entities.dtos.request.AbilityDto;


public interface AbilityService {
	Result add(Ability ability);
	Result update(Ability ability);
	Result delete(int id);
	DataResult<List<Ability>> getAll();
	boolean existsById(int id);
}
