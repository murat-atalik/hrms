package findajob.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import findajob.hrms.business.abstracts.CurriculumVitaeService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.CurriculumVitae;
import findajob.hrms.entities.dtos.request.CVAddDto;

@RestController
@RequestMapping("api/cv")
@CrossOrigin
public class CurriculumVitaesController {

	private CurriculumVitaeService curriculumVitaeService;

	@Autowired
	public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
		this.curriculumVitaeService = curriculumVitaeService;

	}

	@PostMapping("/add")
	public Result add(@RequestBody CVAddDto curriculumVitae) {
		return this.curriculumVitaeService.addCv(curriculumVitae);
	}

	@PostMapping("/addImage")
	public Result add(@RequestParam int id, @RequestParam MultipartFile file) {
		return this.curriculumVitaeService.addImage(id, file);
	}

	@GetMapping("/getAll")
	public DataResult<List<CurriculumVitae>> getAll() {
		return this.curriculumVitaeService.getAll();
	}

	@GetMapping("/sortByExperience")
	public DataResult<List<CurriculumVitae>> sortByExperience() {
		return this.curriculumVitaeService.getAllSortedByExperienceQuitDate();
	}

	@GetMapping("/sortByGraduate")
	public DataResult<List<CurriculumVitae>> sortByGraduate() {
		return this.curriculumVitaeService.getAllSortedByGraduateDate();
	}

	@GetMapping("/getbyid")
	public DataResult<List<CurriculumVitae>> getById(@RequestParam int id) {
		return this.curriculumVitaeService.getByCandidateId(id);
	}

}
