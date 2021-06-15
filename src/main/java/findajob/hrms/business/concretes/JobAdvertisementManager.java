package findajob.hrms.business.concretes;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.CityService;
import findajob.hrms.business.abstracts.EmployerService;
import findajob.hrms.business.abstracts.JobAdvertisementService;
import findajob.hrms.business.abstracts.JobPositionService;
import findajob.hrms.business.abstracts.TypeOfWorkService;
import findajob.hrms.business.abstracts.WorkProgramService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.core.utilities.results.SuccessDataResult;
import findajob.hrms.core.utilities.results.SuccessResult;
import findajob.hrms.dataAccess.abstracts.JobAdvertisementDao;
import findajob.hrms.entities.concretes.JobAdvertisement;
import findajob.hrms.entities.dtos.request.JobAdvertAddDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	private CityService cityService;
	private EmployerService employerService;
	private JobPositionService jobPositionService;
	private WorkProgramService workProgramService;
	private TypeOfWorkService typeOfWorkService;
	
		@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, CityService cityService,
			EmployerService employerService, JobPositionService jobPositionService,TypeOfWorkService typeOfWorkService,
			WorkProgramService workProgramService) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.cityService = cityService;
		this.employerService = employerService;
		this.jobPositionService = jobPositionService;
		this.workProgramService = workProgramService;
		this.typeOfWorkService =typeOfWorkService;
	}



	@Override
	public Result add(JobAdvertAddDto jobAdvertisement) {
		JobAdvertisement temp = new JobAdvertisement();
		
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		temp.setReleaseDate(date);
		temp.setActive(jobAdvertisement.isActive());
		temp.setApplicationDeadline(jobAdvertisement.getApplicationDeadline());
		temp.setJobDescription(jobAdvertisement.getJobDescription());
		temp.setMaxSalary(jobAdvertisement.getMaxSalary());
		temp.setMinSalary(jobAdvertisement.getMinSalary());
		temp.setOpenPosition(jobAdvertisement.getOpenPosition());
		
		temp.setSystemConfirmation(false);
		
		
		temp.setTypeOfWork(this.typeOfWorkService.getById( jobAdvertisement.getRemoteId()).getData());	
		temp.setCity(this.cityService.getByPlateNumber(jobAdvertisement.getCityPlatenumber()).getData());
		temp.setEmployer(this.employerService.getById(jobAdvertisement.getEmployerId()).getData());
		temp.setJobPosition(this.jobPositionService.getById(jobAdvertisement.getJobPositionId()).getData());
		temp.setWorkProgram(this.workProgramService.getById(jobAdvertisement.getWorkProgramId()).getData());
		
		
		this.jobAdvertisementDao.save(temp);
		return new SuccessResult("Job Advertisement added  " + date);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllActive(), "Listed");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.ASC, "applicationDeadline");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllActiveByCreatedDate(), "Sorted");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployer_CompanyId(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllActiveByEmployer_CompanyId(id),
				"Companies listed by company id");
	}

	@Override
	public DataResult<JobAdvertisement> changeActiveStatus(int id) {
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.getById(id);
		if (jobAdvertisement.isActive()) {
			jobAdvertisement.setActive(false);
		} else jobAdvertisement.setActive(true);
		
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getById(id));
	}
	@Override
	public DataResult<JobAdvertisement> changeConfirmStatus(int id) {
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.getById(id);
		if (jobAdvertisement.isSystemConfirmation()) {
			jobAdvertisement.setSystemConfirmation(false);
		} else jobAdvertisement.setSystemConfirmation(true);
		
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getById(id));
	}



	@Override
	public DataResult<List<JobAdvertisement>> getAllConfirmed() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllSystemConfirmed());
	}



	@Override
	public DataResult<List<JobAdvertisement>> getAllUnConfirmed() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllSystemUnConfirmed());
	}

}