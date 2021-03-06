package findajob.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.BcryptService;
import findajob.hrms.business.abstracts.RoleService;
import findajob.hrms.business.abstracts.StaffService;
import findajob.hrms.business.abstracts.UserService;
import findajob.hrms.core.helpers.BusinessRules;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.ErrorResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.core.utilities.results.SuccessDataResult;
import findajob.hrms.core.utilities.results.SuccessResult;
import findajob.hrms.dataAccess.abstracts.StaffDao;
import findajob.hrms.entities.concretes.Staff;
import findajob.hrms.entities.dtos.request.StaffAddDto;
import findajob.hrms.entities.dtos.request.StaffUpdateDto;

@Service
public class StaffManager implements StaffService {

	private StaffDao staffDao;
	private UserService userService;
	private RoleService roleService;
	private BcryptService bcryptService;

	@Autowired
	public StaffManager(StaffDao staffDao, UserService userService, RoleService roleService, BcryptService bcryptService) {
		this.staffDao = staffDao;
		this.userService = userService;
		this.roleService = roleService;
		this.bcryptService= bcryptService;
	}

	@Override
	public Result add(StaffAddDto staff) {

		Result error = BusinessRules.Run(this.EmailVerification(staff.getEmail()), this.EmailCheck(staff.getEmail()),
				this.PasswordCheck(staff.getPassword(), staff.getRePassword()),this.RoleCheck(staff.getRoleId()));
		if (error.isSuccess()) {
			Staff tempStaff = new Staff();
			tempStaff.setEmail(staff.getEmail());
			tempStaff.setFirstName(staff.getFirstName());
			tempStaff.setLastName(staff.getLastName());
			tempStaff.setPassword(this.bcryptService.encryptValue(staff.getPassword()));
			tempStaff.setUserType("staff");
			tempStaff.setSecurityAnswer(this.bcryptService.encryptValue(staff.getSecurityAnswer()));
			tempStaff.setRole(this.roleService.getById(staff.getRoleId()).getData());
			this.staffDao.save(tempStaff);
			tempStaff.setUserId(this.userService.getByEmail(staff.getEmail()).getData().getId());
			this.staffDao.save(tempStaff);
			return new SuccessResult("System personel addedd");
		}
		return error;
	}
	@Override
	public Result update(StaffUpdateDto staff) {

		Result error = BusinessRules.Run(this.EmailVerification(staff.getEmail()), 
				this.RoleCheck(staff.getRoleId()));
		if (error.isSuccess()) {
			Staff tempStaff = this.staffDao.getById(staff.getId());
			
			tempStaff.setFirstName(staff.getFirstName());
			tempStaff.setLastName(staff.getLastName());
			tempStaff.setRole(this.roleService.getById(staff.getRoleId()).getData());			
			if(!staff.getSecurityAnswer().isEmpty()) {
				tempStaff.setSecurityAnswer(this.bcryptService.encryptValue(staff.getSecurityAnswer()));
				}
		if(tempStaff.getEmail().equals(staff.getEmail())) {
			this.staffDao.save(tempStaff);
			return new SuccessResult("B??LG??LER G??NCELLEND??");
		}
	if(!this.userService.existByemail(staff.getEmail())&&!tempStaff.getEmail().equals(staff.getEmail())) {
						tempStaff.setEmail(staff.getEmail());
						this.staffDao.save(tempStaff);
						return new SuccessResult("B??LG??LER G??NCELLEND??");
		}
			
			return new ErrorResult("MA??L ADRES?? KULLANIMDA");
		}
		return error;
	}

	@Override
	public DataResult<List<Staff>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Staff>>(this.staffDao.findAll(), "System personel listed");
	}

	private Result EmailVerification(String email) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			return new SuccessResult();
		}
		return new ErrorResult("Email verification error");
	}

	private Result EmailCheck(String email) {

		if (!this.userService.existByemail(email)) {
			return new SuccessResult();
		}
		return new ErrorResult("EMA??L ADRES?? KULLANIMDA");
	}


	private Result PasswordCheck(String password, String rePassword) {

		if (password.equals(rePassword)) {
			return new SuccessResult();
		}
		return new ErrorResult("Password must equal");
	}
	private Result RoleCheck(int id) {

		if (this.roleService.existsRoleById(id).isSuccess()) {
			return new SuccessResult();
		}
		return new ErrorResult("Role not exists"+this.roleService.getById(id).getData());
	}

	@Override
	public DataResult<Staff> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Staff>(this.staffDao.getById(id),"User listelendi");
	}
}
