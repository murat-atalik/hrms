package findajob.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.BcryptService;
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
import findajob.hrms.entities.dtos.request.CandidateDto;
import findajob.hrms.entities.dtos.request.CandidateUpdateDto;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserCheckService userCheckService;
	private UserService userService;
	private BcryptService bcryptService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, FakeCheck userCheckService, UserService userService, BcryptService bcryptService) {
		this.candidateDao = candidateDao;
		this.userCheckService = userCheckService;
		this.userService = userService;
		this.bcryptService =bcryptService;
	}

	// TODO: hatayı bul db ye fazladan bir user ekleniyor 
	@Override
	public Result add(CandidateDto candidate) {

		Result error = BusinessRules.Run(this.findByNationalityId(candidate.getNationalityId()),
				this.findByEmail(candidate.getEmail()), this.PasswordCheck(candidate),
				this.userCheckService.CheckIfRealPerson(candidate));
		if (error.isSuccess()) {

			
			Candidate tempCandidate = new Candidate();

			tempCandidate.setBirthday(candidate.getBirthday());
			tempCandidate.setEmailVerification(true);
			tempCandidate.setFirstName(candidate.getFirstName());
			tempCandidate.setLastName(candidate.getLastName());
			tempCandidate.setNationalityId(candidate.getNationalityId());
			tempCandidate.setPassword(this.bcryptService.encryptValue(candidate.getPassword()));
			tempCandidate.setEmail(candidate.getEmail());
			tempCandidate.setUserType("candidate");
			tempCandidate.setSecurityAnswer(this.bcryptService.encryptValue(candidate.getSecurityAnswer()));
			//TODO: Geçici çözüm User ile candidate arasındaki one to one kaldırıldı
			this.candidateDao.save(tempCandidate);
			tempCandidate.setUserId(this.userService.getByEmail(candidate.getEmail()).getData().getId());
			this.candidateDao.save(tempCandidate);
			
			return new SuccessResult("İŞ ARAYAN EKLENDİ");
		}
		return error;
	}
	@Override
	public Result update(CandidateUpdateDto candidate) {
		Candidate tempCandidate = this.candidateDao.getById(candidate.getCandidateId());
		tempCandidate.setBirthday(candidate.getBirthday());
		tempCandidate.setFirstName(candidate.getFirstName());
		tempCandidate.setLastName(candidate.getLastName());

		if(!candidate.getSecurityAnswer().isEmpty()) {
		tempCandidate.setSecurityAnswer(this.bcryptService.encryptValue(candidate.getSecurityAnswer()));
		}
		if (tempCandidate.getEmail().equals(candidate.getEmail())) {
			
			this.candidateDao.save(tempCandidate);
			
			return new SuccessResult("BİLGİLER GÜNCELLENDİ");
		}
		if(!this.userService.existByemail(candidate.getEmail())) {
			tempCandidate.setEmail(candidate.getEmail());
			this.candidateDao.save(tempCandidate);
			return new SuccessResult("BİLGİLER GÜNCELLENDİ");
			}
		return new ErrorResult("MAİL ADRESİ KULLANIMDA");
	}
	@Override
	public DataResult<List<Candidate>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "İş arayanlar listelendi");
	}

	private Result findByNationalityId(String nationalityId) {
		if (this.candidateDao.existsCandidateByNationalityId(nationalityId)) {
			return new ErrorResult("TC KİMLİK NO KULLANIMDA");
		}
		return new SuccessResult();
	}

	private Result findByEmail(String email) {
		if (this.userService.existByemail(email)) {
			return new ErrorResult("MAİL HESABI KULLANIMDA");
		}
		return new SuccessResult();
	}
	private Result findCandidateEmail(String email,int id) {
		Candidate temp = this.candidateDao.getById(id);
		if (temp.getEmail().equals(email)) {
			return new SuccessResult();
		}
		return new ErrorResult("MAİL ADRESİ UYUŞMAMAKTADIR");
	}

	// Fake email verification
	private Result emailVerification(String email) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			return new SuccessResult();
		}
		return new ErrorResult("LÜTFEN GEÇERLİ BİR EMAİL ADRESİ GİRİN");
	}

	private Result PasswordCheck(CandidateDto candidate) {
		if (candidate.getPassword().equals(candidate.getRePassword())) {
			return new SuccessResult();
		}
		return new ErrorResult("ŞİFRELER UYUŞMUYOR");
	}

	@Override
	public DataResult<Candidate> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Candidate>(this.candidateDao.getOne(id));
	}

}
