package findajob.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import findajob.hrms.business.abstracts.CurriculumVitaeService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.CurriculumVitae;
import findajob.hrms.entities.dtos.request.CVAddDto;
import findajob.hrms.entities.dtos.request.CVUpdateDto;

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
	@PostMapping("/update")
	public Result update(@RequestBody CVUpdateDto curriculumVitae) {
		return this.curriculumVitaeService.update(curriculumVitae);
	}
	@PostMapping(value="/addsa",consumes= {
			MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE
			
	})
	public Result addsa(@RequestPart  CVAddDto curriculumVitae, @RequestPart MultipartFile file) {
		return this.curriculumVitaeService.addCv(curriculumVitae);
	}
	@PostMapping("/addImage")
	public Result add(@RequestBody int id, @RequestBody MultipartFile file) {
		return this.curriculumVitaeService.addImage(id, file);
	}
	@PostMapping("/addFile")
	public Result add( @RequestBody MultipartFile file) {
		return this.curriculumVitaeService.addFile( file);
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
	public DataResult<CurriculumVitae> getById(@RequestParam int id) {
		return this.curriculumVitaeService.getById(id);
	}
	@GetMapping("/getbycandidateid")
	public DataResult<List<CurriculumVitae>> getByCandidateId(@RequestParam int id) {
		return this.curriculumVitaeService.getByCandidateId(id);
	}

}
