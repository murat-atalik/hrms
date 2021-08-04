package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.User;
import findajob.hrms.entities.dtos.request.ChangePasswordDto;
import findajob.hrms.entities.dtos.request.ForgotPasswordDto;
import findajob.hrms.entities.dtos.request.LoginDto;
import findajob.hrms.entities.dtos.response.LoginResultDto;

public interface UserService {
	Result add(User user);
	Result changePassword (ChangePasswordDto password);
	Result forgotPassword(ForgotPasswordDto password);

	Result delete(int id);
	DataResult<List<User>> getAll();
	DataResult<User> getByEmail(String email);
	DataResult<LoginResultDto> login(LoginDto login);
}
