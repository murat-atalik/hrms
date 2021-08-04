package findajob.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import findajob.hrms.business.abstracts.CandidateService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.Candidate;
import findajob.hrms.entities.dtos.request.CandidateDto;

@RestController
@RequestMapping("api/candidates")
@CrossOrigin
public class CandidatesController {
	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CandidateDto candidate  ) {
		return this.candidateService.add(candidate);
	}
	@PostMapping("/update")
	public Result update(@RequestBody CandidateDto candidate  ) {
		return this.candidateService.update(candidate);
	}

	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll() {
		return this.candidateService.getAll();
	}

}
