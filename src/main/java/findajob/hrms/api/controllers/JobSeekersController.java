package findajob.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import findajob.hrms.business.abstracts.JobSeekerService;
import findajob.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("api/jobseekers")
public class JobSeekersController {
	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		this.jobSeekerService = jobSeekerService;
	}

	@PostMapping("/add")
	public void add(@RequestBody JobSeeker jobSeeker) {
		this.jobSeekerService.add(jobSeeker);
	}

	@GetMapping("/getall")
	public List<JobSeeker> getAll() {
		return this.jobSeekerService.getAll();
	}

}