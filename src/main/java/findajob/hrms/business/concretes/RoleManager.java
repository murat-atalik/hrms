package findajob.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.RoleService;
import findajob.hrms.dataAccess.abstracts.RoleDao;
import findajob.hrms.entities.concretes.Role;

@Service
public class RoleManager implements RoleService {

	private RoleDao roleDao;
	
	@Autowired
	public RoleManager(RoleDao roleDao) {
		this.roleDao=roleDao;
	}
	
	@Override
	public void add(Role role) {
		this.roleDao.save(role);
		
	}

	@Override
	public List<Role> getAll() {
		return this.roleDao.findAll();
	}

}
