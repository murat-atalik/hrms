package findajob.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import findajob.hrms.entities.concretes.JobAdvertApplies;

public interface JobAdvertAppliesDao extends JpaRepository<JobAdvertApplies, Integer>  {
	@Query("From JobAdvertApplies where id=:id")
	JobAdvertApplies getById(int id);
	@Query("From JobAdvertApplies where candidate.id=:candidateId and jobAdvertisement.id=:jobAdvertId ")
	List<JobAdvertApplies> checkAplly(int candidateId, int jobAdvertId);
	@Query("From JobAdvertApplies where candidate.id=:id")
	List<JobAdvertApplies> getByCandidateId(int id);
	@Query("From JobAdvertApplies where jobAdvertisement.id=:id")
	List<JobAdvertApplies> getByJobAdvertId(int id);
	@Query("From JobAdvertApplies where status=:stat and jobAdvertisement.id=:id")
	List<JobAdvertApplies> getStatus(String stat,int id);
	
}
