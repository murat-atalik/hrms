package findajob.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import findajob.hrms.entities.concretes.JobAdvertisement;
import findajob.hrms.entities.dtos.request.JobAdvertFilter;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	List<JobAdvertisement> getByEmployer_CompanyId(int id);


	List<JobAdvertisement> getByEmployerId(int id);

	@Query("From JobAdvertisement where id=:id")
	JobAdvertisement getById(int id);

	@Query("From JobAdvertisement where active=true")
	List<JobAdvertisement> getAllActive();

	@Query("From JobAdvertisement where active=true Order By applicationDeadline Asc")
	List<JobAdvertisement> getAllActiveByCreatedDate();

	@Query("From JobAdvertisement where systemConfirmation= true and  active= true and employer.company.id=:id")
	List<JobAdvertisement> getAllActiveByEmployer_CompanyId(int id);
	
	@Query("From JobAdvertisement where systemConfirmation= true and  active= true and employer.id=:id")
	List<JobAdvertisement> getAllActiveByEmployerId(int id);
	
	@Query("From JobAdvertisement where systemConfirmation= true and  active= false and employer.id=:id")
	List<JobAdvertisement> getAllPassiveByEmployerId(int id);
	
	@Query("From JobAdvertisement where systemConfirmation = false and employer.id=:id")
	List<JobAdvertisement> getAllUnconfirmedByEmployerId(int id);
	
	@Query("From JobAdvertisement where systemConfirmation= true and active=true")
	List<JobAdvertisement> getAllSystemConfirmed();

	@Query("From JobAdvertisement where systemConfirmation= false ")
	List<JobAdvertisement> getAllSystemUnConfirmed();
	
	@Query("Select j from JobAdvertisement j where ((:#{#filter.cityId}) IS NULL OR j.city.id IN (:#{#filter.cityId}))"
	        +" and ((:#{#filter.jobPositionId}) IS NULL OR j.jobPosition.id IN (:#{#filter.jobPositionId}))"
	        +" and ((:#{#filter.workProgramId}) IS NULL OR j.workProgram.id IN (:#{#filter.workProgramId}))"
	        +" and ((:#{#filter.workTypeId}) IS NULL OR j.workType.id IN (:#{#filter.workTypeId}))"
	        + "and j.systemConfirmation=true"
	        +" and j.active=true")
 List<JobAdvertisement> getByFilter(@Param("filter") JobAdvertFilter jobAdFilter);
}