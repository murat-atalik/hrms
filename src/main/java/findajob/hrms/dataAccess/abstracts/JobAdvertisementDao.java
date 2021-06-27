package findajob.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import findajob.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	List<JobAdvertisement> getByEmployer_CompanyId(int id);


	List<JobAdvertisement> getByEmployerId(int id);

	@Query("From JobAdvertisement where id=:id")
	JobAdvertisement getById(int id);

	@Query("From JobAdvertisement where active=true")
	List<JobAdvertisement> getAllActive();

	@Query("From JobAdvertisement where active=true Order By applicationDeadline Asc")
	List<JobAdvertisement> getAllActiveByCreatedDate();

	@Query("From JobAdvertisement where active= true and employer.company.id=:id")
	List<JobAdvertisement> getAllActiveByEmployer_CompanyId(int id);

	@Query("From JobAdvertisement where systemConfirmation= true ")
	List<JobAdvertisement> getAllSystemConfirmed();

	@Query("From JobAdvertisement where systemConfirmation= false ")
	List<JobAdvertisement> getAllSystemUnConfirmed();
}