package findajob.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.CandidateService;
import findajob.hrms.business.abstracts.CurriculumVitaeService;
import findajob.hrms.business.abstracts.JobAdvertAppliesService;
import findajob.hrms.business.abstracts.JobAdvertisementService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.ErrorResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.core.utilities.results.SuccessDataResult;
import findajob.hrms.core.utilities.results.SuccessResult;
import findajob.hrms.dataAccess.abstracts.JobAdvertAppliesDao;
import findajob.hrms.entities.concretes.JobAdvertApplies;
import findajob.hrms.entities.dtos.request.JobAdvertAppliesDto;

@Service
public class JobAdvertAppliesManager implements JobAdvertAppliesService {
	private JobAdvertAppliesDao jobAdvertAppliesDao;
	private CandidateService candidateService;
	private JobAdvertisementService jobAdvertisementService;
	private CurriculumVitaeService curriculumVitaeService;
	@Autowired
	public JobAdvertAppliesManager(JobAdvertAppliesDao jobAdvertAppliesDao, CandidateService candidateService, CurriculumVitaeService curriculumVitaeService,JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertAppliesDao = jobAdvertAppliesDao;
		this.candidateService = candidateService;
		this.jobAdvertisementService = jobAdvertisementService;
		this.curriculumVitaeService = curriculumVitaeService;
	}
	@Override
	public Result add(JobAdvertAppliesDto applies) {
		JobAdvertApplies jobAdvertApplies= new JobAdvertApplies();
		if(this.jobAdvertAppliesDao.checkAplly(applies.getCandidateId(),applies.getJobAdvertisementId()).isEmpty()) {
		if(this.curriculumVitaeService.getByCandidateIdActive(applies.getCandidateId()).getData()!=null) {
			jobAdvertApplies.setCandidate(this.candidateService.getById(applies.getCandidateId()).getData());
			jobAdvertApplies.setJobAdvertisement(this.jobAdvertisementService.getById(applies.getJobAdvertisementId()).getData());
			jobAdvertApplies.setStatus("BEKLEMEDE");
			jobAdvertApplies.setCurriculumVitae(this.curriculumVitaeService.getByCandidateIdActive(applies.getCandidateId()).getData());
		this.jobAdvertAppliesDao.save(jobAdvertApplies);
			return new SuccessResult("BA??VURU YAPILDI.");
		}
		return new ErrorResult("AKT??F CV BULUNMAMAKTADIR.");
	}
		return new ErrorResult("B??RDEN FAZLA BA??VURU YAPILAMAZ.");
	}

	@Override
	public Result delete(int id) {
		this.jobAdvertAppliesDao.deleteById(id);
		return new SuccessResult("BA??VURU S??L??ND??.");
	}

	@Override
	public Result statusDenied(int id) {
		JobAdvertApplies jobAdvertApplies=this.jobAdvertAppliesDao.getById(id);
		jobAdvertApplies.setStatus("REDDED??LD??");
		this.jobAdvertAppliesDao.save(jobAdvertApplies);
		return new SuccessResult("???? BA??VURUSU REDDED??LD??.");
	}

	@Override
	public Result statusApproved(int id) {
		JobAdvertApplies jobAdvertApplies=this.jobAdvertAppliesDao.getById(id);
		jobAdvertApplies.setStatus("ONAYLANDI");
		this.jobAdvertAppliesDao.save(jobAdvertApplies);
		return new SuccessResult("???? BA??VURUSU ONAYLANDI.");
	}

	@Override
	public Result statusPending(int id) {
		JobAdvertApplies jobAdvertApplies=this.jobAdvertAppliesDao.getById(id);
		jobAdvertApplies.setStatus("BEKLEMEDE");
		this.jobAdvertAppliesDao.save(jobAdvertApplies);
		return new SuccessResult("???? BA??VURUSU BEKLEMEDE.");
	}

	@Override
	public DataResult<JobAdvertApplies> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<JobAdvertApplies>(this.jobAdvertAppliesDao.getById(id));
	}

	@Override
	public DataResult<List<JobAdvertApplies>> getByCandidateId(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertApplies>>(this.jobAdvertAppliesDao.getByCandidateId(id));
	}

	@Override
	public DataResult<List<JobAdvertApplies>> getByJobAdvertId(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertApplies>>(this.jobAdvertAppliesDao.getByJobAdvertId(id));
	}

	@Override
	public DataResult<List<JobAdvertApplies>> getApproved(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertApplies>>(this.jobAdvertAppliesDao.getStatus("ONAYLANDI",id));
	}

	@Override
	public DataResult<List<JobAdvertApplies>> getDenied(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertApplies>>(this.jobAdvertAppliesDao.getStatus("REDDED??LD??",id));
	}

	@Override
	public DataResult<List<JobAdvertApplies>> getPending(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertApplies>>(this.jobAdvertAppliesDao.getStatus("BEKLEMEDE",id));
	}
	@Override
	public DataResult<Boolean> checkAplly(int candidateId, int jobAdvertId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Boolean>(this.jobAdvertAppliesDao.checkAplly(candidateId, jobAdvertId).isEmpty());
	}

}
