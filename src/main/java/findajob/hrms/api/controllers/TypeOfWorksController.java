package findajob.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import findajob.hrms.business.abstracts.TypeOfWorkService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.TypeOfWork;

@RestController
@RequestMapping("api/typeofwork")
@CrossOrigin
public class TypeOfWorksController {
	private TypeOfWorkService typeOfWorkService;

	@Autowired
	public TypeOfWorksController(TypeOfWorkService typeOfWorkService) {
		super();
		this.typeOfWorkService = typeOfWorkService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody TypeOfWork typeOfWork) {
		return this.typeOfWorkService.add(typeOfWork);
	}

	@GetMapping("/getall")
	public DataResult<List<TypeOfWork>> getAll() {
		return this.typeOfWorkService.getAll();
	}

}
