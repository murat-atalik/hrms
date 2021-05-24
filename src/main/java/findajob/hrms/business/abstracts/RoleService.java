package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.entities.concretes.Role;

public interface RoleService {
	void add(Role role);
	List<Role> getAll();
}
