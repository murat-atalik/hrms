package findajob.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.EmployerService;
import findajob.hrms.core.Business.BusinessRules;
import findajob.hrms.core.utilities.DataResult;
import findajob.hrms.core.utilities.ErrorResult;
import findajob.hrms.core.utilities.Result;
import findajob.hrms.core.utilities.SuccessDataResult;
import findajob.hrms.core.utilities.SuccessResult;
import findajob.hrms.dataAccess.abstracts.EmployerDao;
import findajob.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}

	// TODO: Refactor this code block
	@Override
	public Result add(Employer employer) {

		
		Result error = BusinessRules.Run(EmailVerification(employer.getEmail()),EmployerCheck(employer),EmailCheck(employer.getEmail()));
		employer.setSystemVerification(false);
		
		if(error.isSuccess()) {
		this.employerDao.save(employer);
		return new SuccessResult("Employer added/ need SystemPersonel verification");}
		return error;
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employer Listed");
	}

	private Result EmployerCheck(Employer employer) {
		String[] parts = employer.getEmail().strip().split("@");
		String domain = parts[1];
		if (employer.getCompanyName().strip().isEmpty() || employer.getEmail().strip().isEmpty()
				|| employer.getPassword().strip().isEmpty() || employer.getPhoneNumber().strip().isEmpty()
				|| employer.getWebAddress().strip().isEmpty() || !domain.equals(employer.getWebAddress())) {
			return new SuccessResult();
		}
		return new ErrorResult("All fields required");
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

}
