package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.Experience;

public interface ExperienceService {
	Result add(Experience experience);

	Result delete(int id);

	boolean existsById(int id);

	DataResult<List<Experience>> getAll();
}
