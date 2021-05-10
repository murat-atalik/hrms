package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();

}
