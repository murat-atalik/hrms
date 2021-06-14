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

import findajob.hrms.business.abstracts.JobAdvertisementService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.JobAdvertisement;
import findajob.hrms.entities.dtos.request.JobAdvertAddDto;


@RestController
@RequestMapping("api/jobadvertisement")
@CrossOrigin
public class JobAdvertisementsController {
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertAddDto JobAdvertisement) {
		return this.jobAdvertisementService.add(JobAdvertisement);
	}

	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}
	@GetMapping("/getAllSorted")
	public DataResult<List<JobAdvertisement>> getAllSorted() {
		return this.jobAdvertisementService.getAllSorted();
	}
	@GetMapping("/getByCompany")
	public DataResult<List<JobAdvertisement>> getByCompanyId(@RequestParam int id) {
		return this.jobAdvertisementService.getByEmployer_CompanyId(id);
	}
	@PostMapping("/changeActiveStatus")
	public DataResult<JobAdvertisement> changeActiveStatus(@RequestBody int id) {
		return this.jobAdvertisementService.changeActiveStatus(id);
	}
	@GetMapping("/getAllSystemConfirmed")
	public DataResult<List<JobAdvertisement>> getAllConfirmed() {
		return this.jobAdvertisementService.getAllConfirmed();
	}
	@GetMapping("/getAllSystemUnConfirmed")
	public DataResult<List<JobAdvertisement>> getAllUnConfirmed() {
		return this.jobAdvertisementService.getAllUnConfirmed();
	}
	@PostMapping("/changeConfirmStatus")
	public DataResult<JobAdvertisement> changeConfirmStatus(@RequestBody int id) {
		return this.jobAdvertisementService.changeConfirmStatus(id);
	}
}
