package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.JobAdvertApplies;
import findajob.hrms.entities.dtos.request.JobAdvertAppliesDto;

public interface JobAdvertAppliesService {
	Result add(JobAdvertAppliesDto applies);

	Result delete(int id);

	Result statusDenied(int id);

	Result statusApproved(int id);

	Result statusPending(int id);

	DataResult<JobAdvertApplies> getById(int id);

	DataResult<List<JobAdvertApplies>> getByCandidateId(int id);

	DataResult<List<JobAdvertApplies>> getByJobAdvertId(int id);

	DataResult<List<JobAdvertApplies>> getApproved();

	DataResult<List<JobAdvertApplies>> getDenied();

	DataResult<List<JobAdvertApplies>> getPending();
}
