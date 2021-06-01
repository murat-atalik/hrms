package findajob.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import findajob.hrms.business.abstracts.CurriculumVitaeService;
import findajob.hrms.core.utilities.imageUploaders.ImageService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.core.utilities.results.SuccessDataResult;
import findajob.hrms.core.utilities.results.SuccessResult;
import findajob.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import findajob.hrms.entities.concretes.CurriculumVitae;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

	private CurriculumVitaeDao curriculumVitaeDao;
	private ImageService imageService;

	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao, ImageService imageService) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;
		this.imageService = imageService;
	}

	@Override
	public Result addCv(CurriculumVitae curriculumVitae) {
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult("added");
	}

	@Override
	public Result addImage(int id, MultipartFile file) {
		Map<String, String> result = (Map<String, String>) imageService.save(file).getData();
		CurriculumVitae cv = this.curriculumVitaeDao.getOne(id);
		cv.setImageUrl(result.get("url"));
		this.curriculumVitaeDao.save(cv);
		return new SuccessResult("image added");
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {

		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAll(), "listed");
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAllSortedByGraduateDate() {
		Sort sort = Sort.by(Sort.Direction.DESC, "educations_graduationDate");
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAll(sort), "listed");
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAllSortedByExperienceQuitDate() {
		Sort sort = Sort.by(Sort.Direction.DESC, "experiences_quitDate");
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAll(sort), "listed");
	}

	@Override
	public DataResult<CurriculumVitae> getByCandidateId(int id) {

		return new SuccessDataResult<CurriculumVitae>(this.curriculumVitaeDao.getOne(id));
	}

}
