package findajob.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;



import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.CurriculumVitae;
import findajob.hrms.entities.dtos.request.CVAddDto;
import findajob.hrms.entities.dtos.request.CVUpdateDto;

public interface CurriculumVitaeService {
	Result addCv(CVAddDto curriculumVitae);
	Result update(CVUpdateDto curriculumVitae);
	Result addImage(int id,MultipartFile file);
	DataResult<String> addFile(MultipartFile file);
	DataResult<List<CurriculumVitae>> getAll();
	DataResult<List<CurriculumVitae>> getAllSortedByGraduateDate();
	DataResult<List<CurriculumVitae>> getAllSortedByExperienceQuitDate();
	DataResult<List<CurriculumVitae>> getByCandidateId(int id);
	DataResult<CurriculumVitae> getById(int id);
}

