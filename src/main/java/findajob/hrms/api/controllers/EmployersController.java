package findajob.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import findajob.hrms.business.abstracts.EmployerService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.Employer;
import findajob.hrms.entities.concretes.JobAdvertisement;
import findajob.hrms.entities.dtos.request.EmployerAddDto;
import findajob.hrms.entities.dtos.request.EmployerUpdateDto;

@RestController
@RequestMapping("api/employers")
@CrossOrigin
public class EmployersController {

	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		this.employerService = employerService;

	}

	@PostMapping("/add")
	public Result add(@RequestBody EmployerAddDto employer) {
		return this.employerService.add(employer);
	}
	@PostMapping("/update")
	public Result update(@RequestBody EmployerUpdateDto employer) {
		return this.employerService.update(employer);
	}

	@GetMapping("/getAll")
	public DataResult<List<Employer>> getAll() {
		return this.employerService.getAll();
	}
	@GetMapping("/getUnConfirmed")
	public DataResult<List<Employer>> getUnConfirmed() {
		return this.employerService.getUnConfirmed();
	}
	@GetMapping("/getbyid")
	public DataResult<Employer> getById(@RequestParam int id) {
		return this.employerService.getById(id);
	}
	@PostMapping("/changeSystemConfirmStatus")
	public Result changeConfirmStatus(@RequestParam int id) {
		return this.employerService.changeConfirmStatus(id);
	}
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.employerService.delete(id);
	}
}
