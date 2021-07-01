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

import findajob.hrms.business.abstracts.UpdatedCompanyService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.UpdatedCompany;

@CrossOrigin
@RestController
@RequestMapping("api/updatecompany")
public class UpdatedCompaniesController {
	private UpdatedCompanyService updatedCompanyService;

	@Autowired
	public UpdatedCompaniesController(UpdatedCompanyService updatedCompanyService) {
		super();
		this.updatedCompanyService = updatedCompanyService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody UpdatedCompany updatedCompany) {
		return this.updatedCompanyService.add(updatedCompany);
	}
	@PostMapping("/update")
	public Result update(@RequestParam int id) {
		return this.updatedCompanyService.update(id);
	}
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.updatedCompanyService.delete(id);
	}
	@GetMapping("/getall")
	public DataResult<List<UpdatedCompany>> getAll() {
		return this.updatedCompanyService.getAll();
	}
	@GetMapping("/getbyemployer")
	public DataResult<UpdatedCompany> getByEmployerId(@RequestParam int id) {
		return this.updatedCompanyService.getByEmployerId(id);
	}
	@GetMapping("/getbycompany")
	public DataResult<UpdatedCompany> getByCompanyId(@RequestParam int id) {
		return this.updatedCompanyService.getByCompanyId(id);
	}

}
