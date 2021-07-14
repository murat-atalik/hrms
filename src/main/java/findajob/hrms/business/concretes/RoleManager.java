package findajob.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.RoleService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.ErrorResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.core.utilities.results.SuccessDataResult;
import findajob.hrms.core.utilities.results.SuccessResult;
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
	public Result add(Role role) {
		this.roleDao.save(role);
		return new SuccessResult("Role eklendi");
	}	@Override
	public Result update(Role role) {
		this.roleDao.save(role);
		return new SuccessResult("Role güncellendi");
	}

	@Override
	public DataResult<List<Role>> getAll() {
		return new SuccessDataResult<List<Role>>( this.roleDao.findAll(),"roles listed");
	}

	@Override
	public Result existsRoleById(int id) {
		if(this.roleDao.existsById(id)) {
		return new SuccessResult();
		}
		return new ErrorResult();
	}

	@Override
	public DataResult<Role> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Role>(this.roleDao.getById(id));
	}

}
