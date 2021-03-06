package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.Language;

public interface LanguageService {
	Result add(Language language);

	Result delete(int id);

	boolean existsById(int id);

	DataResult<List<Language>> getAll();
}
