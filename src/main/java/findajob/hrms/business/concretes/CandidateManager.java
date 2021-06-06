package findajob.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.CandidateService;
import findajob.hrms.business.abstracts.UserService;
import findajob.hrms.core.adapters.FakeCheck;
import findajob.hrms.core.adapters.MernisServiceAdapter;
import findajob.hrms.core.adapters.UserCheckService;
import findajob.hrms.core.helpers.BusinessRules;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.ErrorResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.core.utilities.results.SuccessDataResult;
import findajob.hrms.core.utilities.results.SuccessResult;
import findajob.hrms.dataAccess.abstracts.CandidateDao;
import findajob.hrms.entities.concretes.Candidate;
import findajob.hrms.entities.concretes.User;
import findajob.hrms.entities.dtos.CandidateDto;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserCheckService userCheckService;
	private UserService userService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, FakeCheck userCheckService, UserService userService) {
		this.candidateDao = candidateDao;
		this.userCheckService = userCheckService;
		this.userService = userService;
	}

	// TODO: hatayı bul db ye fazladan bir user ekleniyor 
	@Override
	public Result add(CandidateDto candidate) {

		Result error = BusinessRules.Run(findByNationalityId(candidate.getNationalityId()),
				findByEmail(candidate.getEmail()), this.PasswordCheck(candidate),
				this.userCheckService.CheckIfRealPerson(candidate));
		if (error.isSuccess()) {
			User user = new User();
			user.setEmail(candidate.getEmail());
			user.setPassword(candidate.getPassword());
			
			
			Candidate tempCandidate = new Candidate();

			tempCandidate.setBirthday(candidate.getBirthday());
			tempCandidate.setEmailVerification(true);
			tempCandidate.setFirstName(candidate.getFirstName());
			tempCandidate.setLastName(candidate.getLastName());
			tempCandidate.setNationalityId(candidate.getNationalityId());
			tempCandidate.setPassword(candidate.getPassword());
			tempCandidate.setEmail(candidate.getEmail());
			
			//TODO: Geçici çözüm User ile candidate arasındaki one to one kaldırıldı
			this.candidateDao.save(tempCandidate);
			tempCandidate.setUserId(this.userService.getByEmail(candidate.getEmail()).getData().getId());
			this.candidateDao.save(tempCandidate);
			
			return new SuccessResult("JobSeeker added"+tempCandidate);
		}
		return error;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Job seekers listed");
	}

	private Result findByNationalityId(String nationalityId) {
		if (this.candidateDao.existsCandidateByNationalityId(nationalityId)) {
			return new ErrorResult("NationalityId already exists");
		}
		return new SuccessResult();
	}

	private Result findByEmail(String email) {
		if (this.candidateDao.existsCandidateByEmail(email)) {
			return new ErrorResult("Job Seeker have already account");
		}
		return new SuccessResult();
	}

	// Fake email verification
	private Result emailVerification(String email) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			return new SuccessResult();
		}
		return new ErrorResult("Email verification fail");
	}

	private Result PasswordCheck(CandidateDto candidate) {
		if (candidate.getPassword().equals(candidate.getRePassword())) {
			return new SuccessResult();
		}
		return new ErrorResult("Password & RePassword must same");
	}

	@Override
	public DataResult<Candidate> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Candidate>(this.candidateDao.getOne(id));
	}

}
