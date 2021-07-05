package findajob.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import findajob.hrms.business.abstracts.EducationService;

import findajob.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("api/educations")
@CrossOrigin
public class EducationsController {
	private EducationService educationService;
@Autowired
	public EducationsController(EducationService educationService) {
	
		this.educationService = educationService;
	}
	@DeleteMapping
	public Result delete(@RequestParam int id) {
		return this.educationService.delete(id);
	}
}
