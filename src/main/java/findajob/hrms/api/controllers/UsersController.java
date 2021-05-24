package findajob.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import findajob.hrms.business.abstracts.UserService;

import findajob.hrms.entities.concretes.User;

@RestController
@RequestMapping("api/users")
public class UsersController {
	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {

		this.userService = userService;
	}

	@PostMapping("/add")
	public void add(@RequestBody User user) {
		this.userService.add(user);
	}

	@GetMapping("/getall")
	public List<User> getall() {
		return this.userService.getAll();
	}

}
