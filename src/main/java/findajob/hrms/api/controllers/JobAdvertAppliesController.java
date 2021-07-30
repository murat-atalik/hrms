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
import findajob.hrms.business.abstracts.JobAdvertAppliesService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.JobAdvertApplies;
import findajob.hrms.entities.dtos.request.JobAdvertAppliesDto;

@CrossOrigin
@RestController
@RequestMapping("api/jobadvertapplies")
public class JobAdvertAppliesController {
	private JobAdvertAppliesService jobAdvertAppliesService;

	@Autowired
	JobAdvertAppliesController(JobAdvertAppliesService jobAdvertAppliesService) {
		this.jobAdvertAppliesService = jobAdvertAppliesService;
	}

	@PostMapping("/add")
	Result add(@RequestBody JobAdvertAppliesDto applies) {
		return this.jobAdvertAppliesService.add(applies);
	}

	@DeleteMapping("/delete")
	Result delete(@RequestParam int id) {
		return this.jobAdvertAppliesService.delete(id);
	}

	@PostMapping("/statusDenied")
	Result statusDenied(@RequestParam int id) {
		return this.jobAdvertAppliesService.statusDenied(id);
	}

	@PostMapping("/statusApproved")
	Result statusApproved(@RequestParam int id) {
		return this.jobAdvertAppliesService.statusApproved(id);
	}

	@PostMapping("/statusPending")
	Result statusPending(@RequestParam int id) {
		return this.jobAdvertAppliesService.statusPending(id);
	}

	@GetMapping("/getById")
	DataResult<JobAdvertApplies> getById(@RequestParam int id) {
		return this.jobAdvertAppliesService.getById(id);
	}

	@GetMapping("/getByCandidateId")
	DataResult<List<JobAdvertApplies>> getByCandidateId(@RequestParam int id) {
		return this.jobAdvertAppliesService.getByCandidateId(id);
	}

	@GetMapping("/getByJobAdvertId")
	DataResult<List<JobAdvertApplies>> getByJobAdvertId(@RequestParam int id) {
		return this.jobAdvertAppliesService.getByJobAdvertId(id);
	}

	@GetMapping("/getApproved")
	DataResult<List<JobAdvertApplies>> getApproved(@RequestParam int id) {
		return this.jobAdvertAppliesService.getApproved(id);
	}

	@GetMapping("/getDenied")
	DataResult<List<JobAdvertApplies>> getDenied(@RequestParam int id) {
		return this.jobAdvertAppliesService.getDenied(id);
	}

	@GetMapping("/getPending")
	DataResult<List<JobAdvertApplies>> getPending(@RequestParam int id) {
		return this.jobAdvertAppliesService.getPending(id);
	}
	@GetMapping("/checkapply")
	DataResult<Boolean> getPending(@RequestParam int candidateId ,@RequestParam int jobAdvertId) {
		return this.jobAdvertAppliesService.checkAplly(candidateId,jobAdvertId);
	}
}
