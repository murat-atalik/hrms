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

import findajob.hrms.business.abstracts.BcryptService;
import findajob.hrms.business.abstracts.UserService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.ErrorResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.User;
import findajob.hrms.entities.dtos.request.ChangePasswordDto;
import findajob.hrms.entities.dtos.request.ForgotPasswordDto;
import findajob.hrms.entities.dtos.request.LoginDto;

@RestController
@RequestMapping("api/users")
@CrossOrigin
public class UsersController {
	private UserService userService;
	private BcryptService bcryptService;
	@Autowired
	public UsersController(UserService userService,BcryptService bcryptService) {

		this.userService = userService;
		this.bcryptService=bcryptService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody User user) {
		return this.userService.add(user);
	}
	@PostMapping("/forgotPassword")
	public Result forgotPassword(@RequestBody ForgotPasswordDto password) {
		return this.userService.forgotPassword(password);
	}
	@PostMapping("/changePassword")
	public Result changePassword(@RequestBody ChangePasswordDto password) {
		return this.userService.changePassword(password);
	}
	@PostMapping("/login")
	public Result login(@RequestBody LoginDto login) {
		
		return this.userService.login(login);
		
	}
	@PostMapping("/checkValue")
	public boolean checkValue(@RequestParam String value,@RequestParam String hashed ) {
		
		return this.bcryptService.checkEncrypt(value,hashed);
		
	}
	@PostMapping("/hashpassword")
	public String hashpassword(@RequestParam String value) {
		
		return this.bcryptService.encryptValue(value);
		
	}
	@GetMapping("/getall")
	public DataResult<List<User>> getall() {
		return this.userService.getAll();
	}

}
