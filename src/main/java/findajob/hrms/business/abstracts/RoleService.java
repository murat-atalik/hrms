package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.core.utilities.DataResult;
import findajob.hrms.core.utilities.Result;
import findajob.hrms.entities.concretes.Role;

public interface RoleService {
	Result add(Role role);
	DataResult<List<Role>> getAll();
}
