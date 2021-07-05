package findajob.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import findajob.hrms.business.abstracts.AbilityService;
import findajob.hrms.core.utilities.results.Result;



@RestController
@RequestMapping("api/abilities")
@CrossOrigin
public class AbilitiesController {
	private AbilityService abilitiyService;
@Autowired
	public AbilitiesController(AbilityService abilitiyService) {
	
		this.abilitiyService = abilitiyService;
	}
	@DeleteMapping
	public Result delete(@RequestParam int id) {
		return this.abilitiyService.delete(id);
	}

}
