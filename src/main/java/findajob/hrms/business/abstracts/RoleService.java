package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.Role;

public interface RoleService {
	Result add(Role role);
	DataResult<List<Role>> getAll();
	Result existsRoleById(int id);
	DataResult<Role> getById(int id);
}
