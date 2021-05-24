package findajob.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import findajob.hrms.business.abstracts.RoleService;
import findajob.hrms.core.utilities.DataResult;
import findajob.hrms.core.utilities.Result;
import findajob.hrms.entities.concretes.Role;

@RestController
@RequestMapping("api/roles")
public class RolesController {
	private RoleService roleService;

	@Autowired
	public RolesController(RoleService roleService) {
		this.roleService = roleService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Role role) {
		return this.roleService.add(role);
	}

	@GetMapping("/getall")
	public DataResult<List<Role>> getAll() {
		return this.roleService.getAll();
	}

}
