package findajob.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import findajob.hrms.business.abstracts.UserService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.ErrorResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.User;
import findajob.hrms.entities.dtos.request.LoginDto;

@RestController
@RequestMapping("api/users")
@CrossOrigin
public class UsersController {
	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {

		this.userService = userService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody User user) {
		return this.userService.add(user);
	}
	@PostMapping("/login")
	public Result login(@RequestBody LoginDto login) {
		
		return this.userService.login(login);
		
	}
	@GetMapping("/getall")
	public DataResult<List<User>> getall() {
		return this.userService.getAll();
	}

}
