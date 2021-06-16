package findajob.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import findajob.hrms.business.abstracts.WorkTypeService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.WorkType;


@RestController
@RequestMapping("api/worktype")
@CrossOrigin
public class WorkTypesController {
	private WorkTypeService workTypeService;

	@Autowired
	public WorkTypesController(WorkTypeService workTypeService) {
		super();
		this.workTypeService = workTypeService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody WorkType workType) {
		return this.workTypeService.add(workType);
	}

	@GetMapping("/getall")
	public DataResult<List<WorkType>> getAll() {
		return this.workTypeService.getAll();
	}

}
