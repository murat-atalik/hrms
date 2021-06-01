package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.Ability;

public interface AbilityService {
	Result add(Ability ability);

	DataResult<List<Ability>> getAll();
}
