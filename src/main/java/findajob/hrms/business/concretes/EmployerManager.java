package findajob.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.CompanyService;
import findajob.hrms.business.abstracts.EmployerService;
import findajob.hrms.business.abstracts.UserService;
import findajob.hrms.core.helpers.BusinessRules;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.ErrorResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.core.utilities.results.SuccessDataResult;
import findajob.hrms.core.utilities.results.SuccessResult;
import findajob.hrms.dataAccess.abstracts.EmployerDao;
import findajob.hrms.entities.concretes.Company;
import findajob.hrms.entities.concretes.Employer;
import findajob.hrms.entities.concretes.JobAdvertisement;
import findajob.hrms.entities.concretes.User;
import findajob.hrms.entities.dtos.request.EmployerAddDto;

@Service
public class EmployerManager implements EmployerService {
	private EmployerDao employerDao;
	private CompanyService companyService;
	private UserService userService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, CompanyService companyService, UserService userService) {
		this.employerDao = employerDao;
		this.companyService = companyService;
		this.userService = userService;
	}

	// TODO: Refactor this code block
	@Override
	public Result add(EmployerAddDto employer) {

		Result error = BusinessRules.Run(EmailVerification(employer.getEmail()), EmployerCheck(employer),
				EmailCheck(employer.getEmail()), PasswordCheck(employer.getPassword(), employer.getRePassword()));

		Employer tempEmployer = new Employer();

		if (this.companyService.getByWebAdress(employer.getWebAddress()).getData() == null) {

			Company tempCompany = new Company();
			tempCompany.setCompanyName(employer.getCompanyName());
			tempCompany.setWebAddress(employer.getWebAddress());
			this.companyService.Add(tempCompany);
		}

		tempEmployer.setCompany(this.companyService.getByWebAdress(employer.getWebAddress()).getData());
		tempEmployer.setEmail(employer.getEmail());
		tempEmployer.setEmailVerification(true);
		tempEmployer.setPassword(employer.getPassword());
		tempEmployer.setPhoneNumber(employer.getPhoneNumber());
		tempEmployer.setSystemVerification(false);
		tempEmployer.setUserId(0);

		if (error.isSuccess()) {
			this.employerDao.save(tempEmployer);
			tempEmployer.setUserId(this.userService.getByEmail(employer.getEmail()).getData().getId());
			this.employerDao.save(tempEmployer);
			return new SuccessResult("Employer added/ need SystemPersonel verification");
		}
		return new ErrorResult(error.getMessage());
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employer Listed");
	}

	@Override
	public DataResult<Employer> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Employer>(this.employerDao.getOne(id));
	}

	@Override
	public DataResult<Employer> changeConfirmStatus(int id) {
		Employer temp = this.employerDao.getOne(id);
		if (temp.isSystemVerification()) {
			temp.setSystemVerification(false);
		}
		else temp.setSystemVerification(true);
		this.employerDao.save(temp);

		return new SuccessDataResult<Employer>(this.employerDao.getOne(id), "Status changed: "+temp.isSystemVerification());
	}

	private Result EmployerCheck(EmployerAddDto employer) {
		String[] domainParts = employer.getEmail().split("@");
		String domain = "www." + domainParts[1];

		if (domain.equals(employer.getWebAddress())) {
			return new SuccessResult();
		}
		return new ErrorResult("  email nor mathced " + domain + "+" + employer.getWebAddress());
	}

	// Fake email verification
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

		if (!this.employerDao.existsEmployerByEmail(email)) {
			return new SuccessResult();
		}
		return new ErrorResult("Invalid email");
	}

	private Result PasswordCheck(String password, String rePassword) {

		if (password.equals(rePassword)) {
			return new SuccessResult();
		}
		return new ErrorResult("Password must equal");
	}

}
