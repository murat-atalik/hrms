package findajob.hrms.business.concretes;

import java.time.LocalDate;
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
import findajob.hrms.entities.dtos.request.AbilityDto;
import findajob.hrms.entities.dtos.request.CVAddDto;
import findajob.hrms.entities.dtos.request.CVUpdateDto;
import findajob.hrms.entities.dtos.request.EducationDto;
import findajob.hrms.entities.dtos.request.ExperienceDto;
import findajob.hrms.entities.dtos.request.LanguageDto;

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
		cv.setFirstName(curriculumVitae.getFirstName());
		cv.setLastName(curriculumVitae.getLastName());
		cv.setEmail(curriculumVitae.getEmail());
		cv.setCoverLetter(curriculumVitae.getCoverLetter());
		cv.setActive(false);
		LocalDate now = LocalDate.now();
		cv.setCreatedDate(now);
		cv.setImageUrl(curriculumVitae.getImageUrl());
		cv.setGithub(curriculumVitae.getGithub());
		cv.setLinkedin(curriculumVitae.getLinkedin());
		CurriculumVitae tempCv = this.curriculumVitaeDao.save(cv);

		for (EducationDto educationDto : curriculumVitae.getEducations()) {
			Education education = new Education();
			education.setGraduationDate(educationDto.getGraduationDate());
			education.setSchoolName(educationDto.getSchoolName());
			education.setStartingDate(educationDto.getStartingDate());
			education.setCurriculum_vitae(tempCv);
			this.educationService.add(education);
		}

		for (AbilityDto abilityDto : curriculumVitae.getAbilities()) {
			Ability ability = new Ability();
			ability.setAbilityName(abilityDto.getAbilityName());
			ability.setCurriculum_vitae(tempCv);
			this.abilityService.add(ability);
		}

		for (ExperienceDto experienceDto : curriculumVitae.getExperiences()) {
			Experience experience = new Experience();
			experience.setBusinessName(experienceDto.getBusinessName());
			experience.setPosition(experienceDto.getPosition());
			experience.setQuitDate(experienceDto.getQuitDate());
			experience.setStartingDate(experienceDto.getStartingDate());
			experience.setCurriculum_vitae(tempCv);
			this.experienceService.add(experience);
		}

		for (LanguageDto languageDto : curriculumVitae.getLanguages()) {
			Language language = new Language();
			language.setLanguage(languageDto.getLanguage());
			language.setDegree(languageDto.getDegree());
			language.setCurriculum_vitae(tempCv);
			this.languageService.add(language);

		}

		return new SuccessResult(curriculumVitae + " ");
	}

	@Override
	public Result update(CVUpdateDto curriculumVitae) {
		CurriculumVitae cv = new CurriculumVitae();
		cv.setId(curriculumVitae.getId());
		cv.setCandidate(this.candidateService.getById(curriculumVitae.getCandidateId()).getData());
		cv.setFirstName(curriculumVitae.getFirstName());
		cv.setLastName(curriculumVitae.getLastName());
		cv.setEmail(curriculumVitae.getEmail());
		cv.setCoverLetter(curriculumVitae.getCoverLetter());
		cv.setActive(false);
		LocalDate now = LocalDate.now();
		cv.setCreatedDate(now);
		cv.setImageUrl(curriculumVitae.getImageUrl());
		cv.setGithub(curriculumVitae.getGithub());
		cv.setLinkedin(curriculumVitae.getLinkedin());
		this.curriculumVitaeDao.save(cv);

		for (EducationDto educationDto : curriculumVitae.getEducations()) {
			Education education = new Education();
			education.setGraduationDate(educationDto.getGraduationDate());
			education.setSchoolName(educationDto.getSchoolName());
			education.setStartingDate(educationDto.getStartingDate());
			education.setCurriculum_vitae(cv);
			if (this.abilityService.existsById(educationDto.getId())) {
				education.setId(educationDto.getId());
			}
			this.educationService.add(education);
		}

		for (AbilityDto abilityDto : curriculumVitae.getAbilities()) {
			Ability ability = new Ability();
			ability.setAbilityName(abilityDto.getAbilityName());
			ability.setCurriculum_vitae(cv);
			if (this.abilityService.existsById(abilityDto.getId())) {
				ability.setId(abilityDto.getId());
			}
			this.abilityService.add(ability);
		}
		for (ExperienceDto experienceDto : curriculumVitae.getExperiences()) {
			Experience experience = new Experience();
			experience.setBusinessName(experienceDto.getBusinessName());
			experience.setPosition(experienceDto.getPosition());
			experience.setQuitDate(experienceDto.getQuitDate());
			experience.setStartingDate(experienceDto.getStartingDate());
			experience.setCurriculum_vitae(cv);
			if (this.experienceService.existsById(experienceDto.getId())) {
				experience.setId(experienceDto.getId());
			}
			this.experienceService.add(experience);
		}

		for (LanguageDto languageDto : curriculumVitae.getLanguages()) {
			Language language = new Language();
			language.setLanguage(languageDto.getLanguage());
			language.setDegree(languageDto.getDegree());
			language.setCurriculum_vitae(cv);
			if (this.languageService.existsById(languageDto.getId())) {
				language.setId(languageDto.getId());
			}
			this.languageService.add(language);

		}

		return new SuccessResult(curriculumVitae + " ");
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

	@Override
	public DataResult<CurriculumVitae> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<CurriculumVitae>(this.curriculumVitaeDao.getById(id), "Özgeçmiş listelendi");
	}

	@Override
	public DataResult<String> addFile(MultipartFile file) {
		Map<String, String> result = (Map<String, String>) imageService.save(file).getData();

		return new SuccessDataResult<String>(result.get("url"), "image added");
	}

}
