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

import findajob.hrms.business.abstracts.JobAdvertisementService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.JobAdvertisement;
import findajob.hrms.entities.dtos.request.JobAdvertAddDto;
import findajob.hrms.entities.dtos.request.JobAdvertFilter;


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
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.jobAdvertisementService.delete(id);
	}	@PostMapping("/update")
	public Result update(@RequestBody JobAdvertAddDto JobAdvertisement) {
		return this.jobAdvertisementService.update(JobAdvertisement);
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
	@GetMapping("/getByEmployerActive")
	public DataResult<List<JobAdvertisement>> getByEmployerIdActive(@RequestParam int id) {
		return this.jobAdvertisementService.getByEmployerIdActive(id);
	}@GetMapping("/getById")
	public DataResult<JobAdvertisement> getById(@RequestParam int id) {
		return this.jobAdvertisementService.getById(id);
	}
	@GetMapping("/getByEmployerPassive")
	public DataResult<List<JobAdvertisement>> getByEmployerIPassive(@RequestParam int id) {
		return this.jobAdvertisementService.getAllPassiveByEmployer_CompanyId(id);
	}
	@GetMapping("/getByEmployerUnconfirmed")
	public DataResult<List<JobAdvertisement>> getByEmployerIdUnconfirmed(@RequestParam int id) {
		return this.jobAdvertisementService.getAllUnconfirmedByEmployer_CompanyId(id);
	}
	@PostMapping("/changeActiveStatus")
	public DataResult<JobAdvertisement> changeActiveStatus(@RequestParam int id) {
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
	public DataResult<JobAdvertisement> changeConfirmStatus(@RequestParam int id) {
		return this.jobAdvertisementService.changeConfirmStatus(id);
	}
	@PostMapping("/getAllFiltered")
	public DataResult<List<JobAdvertisement>> getAllFiltered(@RequestBody JobAdvertFilter jobAdvertFilter) {
		return this.jobAdvertisementService.getByIsActiveAndFilter( jobAdvertFilter);
	}
}
