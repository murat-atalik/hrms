package findajob.hrms.business.abstracts;

import java.util.List;



import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.Education;

public interface EducationService {
	Result add(Education education);
	DataResult<List<Education>> getAll();
}
