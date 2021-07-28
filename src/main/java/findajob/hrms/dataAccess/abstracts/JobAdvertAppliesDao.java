package findajob.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import findajob.hrms.entities.concretes.JobAdvertApplies;

public interface JobAdvertAppliesDao extends JpaRepository<JobAdvertApplies, Integer>  {
	@Query("From JobAdvertApplies where id=:id")
	JobAdvertApplies getById(int id);
	@Query("From JobAdvertApplies where candidate.id=:id")
	List<JobAdvertApplies> getByCandidateId(int id);
	@Query("From JobAdvertApplies where jobAdvertisement.id=:id")
	List<JobAdvertApplies> getByJobAdvertId(int id);
	@Query("From JobAdvertApplies where status=ONAYLANDI")
	List<JobAdvertApplies> getApproved();
	@Query("From JobAdvertApplies where status=REDDEDİLDİ")
	List<JobAdvertApplies> getDenied();
	@Query("From JobAdvertApplies where status=BEKLEMEDE")
	List<JobAdvertApplies> getPending();
}
