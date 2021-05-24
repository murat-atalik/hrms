package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.core.utilities.DataResult;
import findajob.hrms.core.utilities.Result;
import findajob.hrms.entities.concretes.User;

public interface UserService {
	Result add(User user);
	DataResult<List<User>> getAll();
}
