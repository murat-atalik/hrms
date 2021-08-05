package findajob.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.UserService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.ErrorDataResult;
import findajob.hrms.core.utilities.results.ErrorResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.core.utilities.results.SuccessDataResult;
import findajob.hrms.core.utilities.results.SuccessResult;
import findajob.hrms.dataAccess.abstracts.UserDao;
import findajob.hrms.entities.concretes.User;
import findajob.hrms.entities.dtos.request.ChangePasswordDto;
import findajob.hrms.entities.dtos.request.ForgotPasswordDto;
import findajob.hrms.entities.dtos.request.LoginDto;
import findajob.hrms.entities.dtos.response.LoginResultDto;

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

	@Override
	public Result delete(int id) {
		this.userDao.deleteById(id);
		return new SuccessResult("Silindi");
	}

	@Override
	public DataResult<LoginResultDto> login(LoginDto login) {
		LoginResultDto result= new LoginResultDto();
		User temp=this.userDao.getByEmail(login.getEmail());
		if(temp!=null && temp.getPassword().equals(login.getPassword())) {
			result.setId(temp.getId());
			result.setUserType(temp.getUserType());
			return new SuccessDataResult<LoginResultDto>(result);
		}
		
		return new ErrorDataResult<LoginResultDto>("Hata");
		
	}

	@Override
	public Result changePassword(ChangePasswordDto password) {
		User temp = this.userDao.getOne(password.getUserId());
		if(temp.getPassword().equals(password.getOldPassword())) {
			if(password.getNewPassword().equals(password.getReNewPassword())) {
			temp.setPassword(password.getNewPassword());
			this.userDao.save(temp);
			return new SuccessResult("ŞİFRE BAŞARIYLA GÜNCELLENDİ");
			}
			return new ErrorResult("ŞİFRELER HATALI!");
			}
		return new ErrorResult("ESKİ ŞİFRENİZ HATALI!");
	}

	@Override
	public Result forgotPassword(ForgotPasswordDto password) {
		User temp = this.userDao.getByEmail(password.getEmail());
		if(temp.getSecurityAnswer().equals(password.getSecurityAnswer())) {
			if(password.getPassword().equals(password.getRePassword())) {
				temp.setPassword(password.getPassword());
				this.userDao.save(temp);
				return new SuccessResult("ŞİFRE BAŞARIYLA GÜNCELLENDİ");
			}
			return new ErrorResult("ŞİFRELER HATALI!");
		}
	return new ErrorResult("GÜVENLİK SORUSU CEVABI HATALI!");
	}



}
