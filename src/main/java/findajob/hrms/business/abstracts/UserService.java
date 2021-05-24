package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.entities.concretes.User;

public interface UserService {
	void add(User user);
	List<User> getAll();
}
