package findajob.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;



import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeService {
	Result addCv(CurriculumVitae curriculumVitae);
	Result addImage(int id,MultipartFile file);
	DataResult<List<CurriculumVitae>> getAll();
	DataResult<List<CurriculumVitae>> getAllSortedByGraduateDate();
	DataResult<List<CurriculumVitae>> getAllSortedByExperienceQuitDate();
	DataResult<CurriculumVitae> getByCandidateId(int id);
}

