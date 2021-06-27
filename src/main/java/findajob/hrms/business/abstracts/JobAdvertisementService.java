package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.JobAdvertisement;
import findajob.hrms.entities.dtos.request.JobAdvertAddDto;

public interface JobAdvertisementService {
	Result add(JobAdvertAddDto jobAdvertisement);

	DataResult<List<JobAdvertisement>> getAll();

	DataResult<List<JobAdvertisement>> getAllSorted();

	DataResult<List<JobAdvertisement>> getByEmployer_CompanyId(int id);
	DataResult<List<JobAdvertisement>> getByEmployerId(int id);
	DataResult<JobAdvertisement> changeActiveStatus(int id);
	DataResult<JobAdvertisement> changeConfirmStatus(int id);
	DataResult<List<JobAdvertisement>> getAllConfirmed();
	DataResult<List<JobAdvertisement>> getAllUnConfirmed();
	DataResult<JobAdvertisement> getById(int id);
}
