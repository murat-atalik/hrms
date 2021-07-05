package findajob.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import findajob.hrms.business.abstracts.ExperienceService;
import findajob.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("api/experiences")
@CrossOrigin
public class ExperiencesController {
	private ExperienceService experienceService;
@Autowired
	public ExperiencesController(ExperienceService experienceService) {
	
		this.experienceService = experienceService;
	}
	@DeleteMapping
	public Result delete(@RequestParam int id) {
		return this.experienceService.delete(id);
	}
}
