package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.User;

public interface UserService {
	Result add(User user);
	DataResult<List<User>> getAll();
	DataResult<User> getByEmail(String email);
}
