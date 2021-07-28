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
		if(this.curriculumVitaeService.getByCandidateIdActive(applies.getCandidateId()).getData()!=null) {
			jobAdvertApplies.setCandidate(this.candidateService.getById(applies.getCandidateId()).getData());
			jobAdvertApplies.setJobAdvertisement(this.jobAdvertisementService.getById(applies.getJobAdvertisementId()).getData());
		this.jobAdvertAppliesDao.save(jobAdvertApplies);
			return new SuccessResult("BAŞVURU YAPILDI.");
		}
		return new ErrorResult("AKTİF CV BULUNMAMAKTADIR.");
	}

	@Override
	public Result delete(int id) {
		this.jobAdvertAppliesDao.deleteById(id);
		return new SuccessResult("BAŞVURU SİLİNDİ.");
	}

	@Override
	public Result statusDenied(int id) {
		JobAdvertApplies jobAdvertApplies=this.jobAdvertAppliesDao.getById(id);
		jobAdvertApplies.setStatus("REDDEDİLDİ");
		this.jobAdvertAppliesDao.save(jobAdvertApplies);
		return new SuccessResult("İŞ BAŞVURUSU REDDEDİLDİ.");
	}

	@Override
	public Result statusApproved(int id) {
		JobAdvertApplies jobAdvertApplies=this.jobAdvertAppliesDao.getById(id);
		jobAdvertApplies.setStatus("ONAYLANDI");
		this.jobAdvertAppliesDao.save(jobAdvertApplies);
		return new SuccessResult("İŞ BAŞVURUSU ONAYLANDI.");
	}

	@Override
	public Result statusPending(int id) {
		JobAdvertApplies jobAdvertApplies=this.jobAdvertAppliesDao.getById(id);
		jobAdvertApplies.setStatus("BEKLEMEDE");
		this.jobAdvertAppliesDao.save(jobAdvertApplies);
		return new SuccessResult("İŞ BAŞVURUSU BEKLEMEDE.");
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
	public DataResult<List<JobAdvertApplies>> getApproved() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertApplies>>(this.jobAdvertAppliesDao.getApproved());
	}

	@Override
	public DataResult<List<JobAdvertApplies>> getDenied() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertApplies>>(this.jobAdvertAppliesDao.getDenied());
	}

	@Override
	public DataResult<List<JobAdvertApplies>> getPending() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertApplies>>(this.jobAdvertAppliesDao.getPending());
	}

}
