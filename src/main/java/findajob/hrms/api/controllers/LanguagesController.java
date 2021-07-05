package findajob.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import findajob.hrms.business.abstracts.LanguageService;
import findajob.hrms.core.utilities.results.Result;
@RestController
@RequestMapping("api/languages")
@CrossOrigin
public class LanguagesController {
	private LanguageService languageService;
@Autowired
	public LanguagesController(LanguageService languageService) {
	
		this.languageService = languageService;
	}
	@DeleteMapping
	public Result delete(@RequestParam int id) {
		return this.languageService.delete(id);
	}
}
