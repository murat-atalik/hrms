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

import findajob.hrms.business.abstracts.StaffService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.CurriculumVitae;
import findajob.hrms.entities.concretes.Staff;
import findajob.hrms.entities.dtos.request.StaffAddDto;
import findajob.hrms.entities.dtos.request.StaffUpdateDto;

@RestController
@RequestMapping("api/staff")
@CrossOrigin
public class StaffsController {

	private StaffService staffService;

	@Autowired
	public StaffsController(StaffService staffService) {
		this.staffService = staffService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody StaffAddDto staff) {
		return this.staffService.add(staff);
	}
	@PostMapping("/update")
	public Result update(@RequestBody StaffUpdateDto staff) {
		return this.staffService.update(staff);
	}
	@GetMapping("/getall")
	public DataResult<List<Staff>> getAll() {
		return this.staffService.getAll();
	}
	@GetMapping("/getbyid")
	public DataResult<Staff> getById(@RequestParam int id) {
		return this.staffService.getById(id);
	}

}
