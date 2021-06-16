package findajob.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import findajob.hrms.business.abstracts.WorkProgramService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;

import findajob.hrms.entities.concretes.WorkProgram;

@RestController
@RequestMapping("api/workprogram")
@CrossOrigin
public class WorkProgramsController {
	private WorkProgramService workProgramService;

	@Autowired
	public WorkProgramsController(WorkProgramService workProgramService) {
		super();
		this.workProgramService = workProgramService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody WorkProgram workProgram) {
		return this.workProgramService.add(workProgram);
	}

	@GetMapping("/getall")
	public DataResult<List<WorkProgram>> getAll() {
		return this.workProgramService.getAll();
	}

}
