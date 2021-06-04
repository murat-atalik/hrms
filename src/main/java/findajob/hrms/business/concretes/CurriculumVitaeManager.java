package findajob.hrms.business.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import findajob.hrms.business.abstracts.AbilityService;
import findajob.hrms.business.abstracts.CandidateService;
import findajob.hrms.business.abstracts.CurriculumVitaeService;
import findajob.hrms.business.abstracts.EducationService;
import findajob.hrms.business.abstracts.ExperienceService;
import findajob.hrms.business.abstracts.LanguageService;
import findajob.hrms.core.utilities.imageUploaders.ImageService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.core.utilities.results.SuccessDataResult;
import findajob.hrms.core.utilities.results.SuccessResult;
import findajob.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import findajob.hrms.entities.concretes.Ability;
import findajob.hrms.entities.concretes.CurriculumVitae;
import findajob.hrms.entities.concretes.Education;
import findajob.hrms.entities.concretes.Experience;
import findajob.hrms.entities.concretes.Language;
import findajob.hrms.entities.dtos.CVAddDto;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

	private CurriculumVitaeDao curriculumVitaeDao;
	private ImageService imageService;
	private CandidateService candidateService;
	private EducationService educationService;
	private AbilityService abilityService;
	private ExperienceService experienceService;
	private LanguageService languageService;

	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao, ImageService imageService,
			CandidateService candidateService, EducationService educationService, AbilityService abilityService,
			ExperienceService experienceService, LanguageService languageService) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;
		this.imageService = imageService;
		this.candidateService = candidateService;
		this.educationService = educationService;
		this.abilityService = abilityService;
		this.experienceService = experienceService;
		this.languageService = languageService;
	}

	@Override
	public Result addCv(CVAddDto curriculumVitae) {
		CurriculumVitae cv = new CurriculumVitae();
		cv.setCandidate(this.candidateService.getById(curriculumVitae.getCandidateId()).getData());
		cv.setCoverLetter(curriculumVitae.getCoverLetter());
		 LocalDate now = LocalDate.now();  
		cv.setCreatedDate(now);
		cv.setImageUrl(curriculumVitae.getImageUrl());
		cv.setGithub(curriculumVitae.getGithub());
		cv.setLinkedin(curriculumVitae.getLinkedin());
		CurriculumVitae tempCv=	this.curriculumVitaeDao.save(cv);
		
		Education education = new Education();
		education.setGraduationDate(curriculumVitae.getGraduationDate());
		education.setSchoolName(curriculumVitae.getSchoolName());
		education.setStartingDate(curriculumVitae.getEducationStartDate());
		education.setCurriculum_vitae(tempCv);
		
		Ability ability = new Ability();
		ability.setAbilityName(curriculumVitae.getAbility());
		ability.setCurriculum_vitae(tempCv);
		
		Experience experience = new Experience();
		experience.setBusinessName(curriculumVitae.getBusinessName());
		experience.setPosition(null);
		experience.setQuitDate(curriculumVitae.getWorkQuitDate());
		experience.setStartingDate(curriculumVitae.getWorkStartDate());
		experience.setCurriculum_vitae(tempCv);
		
		Language language = new Language();
		language.setLanguage(curriculumVitae.getLanguageName());
		language.setDegree(curriculumVitae.getLanguageDegree());
		language.setCurriculum_vitae(tempCv);
		
		this.educationService.add(education);
		this.abilityService.add(ability);
		this.experienceService.add(experience);
		this.languageService.add(language);
		
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
	public DataResult<List<CurriculumVitae>> getByCandidateId(int id) {

		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.getByCandidateId(id));
	}

}
