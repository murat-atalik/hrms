package findajob.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.UserService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.core.utilities.results.SuccessDataResult;
import findajob.hrms.core.utilities.results.SuccessResult;
import findajob.hrms.dataAccess.abstracts.UserDao;
import findajob.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService{
		
	private UserDao userDao;
	
	@Autowired
	public UserManager (UserDao userDao) {
		this.userDao=userDao;
	}
	
	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("user added");
		
	}

	@Override
	public DataResult<List<User>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"users listed");
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		
		return new SuccessDataResult<User>(this.userDao.getByEmail(email));
	}



}
