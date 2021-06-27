package findajob.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.CandidateService;
import findajob.hrms.business.abstracts.FavoriteJobService;
import findajob.hrms.business.abstracts.JobAdvertisementService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.ErrorResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.core.utilities.results.SuccessDataResult;
import findajob.hrms.core.utilities.results.SuccessResult;
import findajob.hrms.dataAccess.abstracts.FavoriteJobDao;
import findajob.hrms.entities.concretes.FavoriteJob;
import findajob.hrms.entities.dtos.request.FavoriteJobDto;

@Service
public class FavoriteJobManager implements FavoriteJobService{
	
	private FavoriteJobDao favoriteJobDao;
	private CandidateService candidateService;
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public FavoriteJobManager(FavoriteJobDao favoriteJobDao,CandidateService candidateService,JobAdvertisementService jobAdvertisementService) {
		super();
		this.favoriteJobDao = favoriteJobDao;
		this.candidateService = candidateService;
		this.jobAdvertisementService=jobAdvertisementService;
	}

	@Override
	public Result add(FavoriteJobDto favoriteJob) {
		FavoriteJob temp = new FavoriteJob();
		temp.setCandidate(this.candidateService.getById(favoriteJob.getCandidateId()).getData());
		temp.setJobAdvertisement(this.jobAdvertisementService.getById(favoriteJob.getJobAdvertisementId()).getData());
		
		if(this.favoriteJobDao.findFavoriteJob(favoriteJob.getCandidateId(), favoriteJob.getJobAdvertisementId()).isEmpty()) {
			this.favoriteJobDao.save(temp);
			return new SuccessResult("Added.");
		}
		return new ErrorResult("İlan Zaten Favorilerde");
		
		
	}

	@Override
	public Result delete(int id) {
		
		this.favoriteJobDao.deleteById(id);
		return new SuccessResult("Deleted");
	}

	@Override
	public Result update(FavoriteJobDto favoriteJob) {
		FavoriteJob temp = new FavoriteJob();
		temp.setId(favoriteJob.getId());
		temp.setCandidate(this.candidateService.getById(favoriteJob.getCandidateId()).getData());
		temp.setJobAdvertisement(this.jobAdvertisementService.getById(favoriteJob.getJobAdvertisementId()).getData());
		this.favoriteJobDao.save(temp);
		return new SuccessResult("updated.");
	}

	@Override
	public DataResult<List<FavoriteJob>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<FavoriteJob>>(this.favoriteJobDao.findAll());
	}

	@Override
	public DataResult<List<FavoriteJob>> getAllByCandidateId(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<FavoriteJob>>(this.favoriteJobDao.getAllByCandidateId(id));
	}

}
