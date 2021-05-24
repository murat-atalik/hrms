package findajob.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.UserService;
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
	public void add(User user) {
		this.userDao.save(user);
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return this.userDao.findAll();
	}

}
