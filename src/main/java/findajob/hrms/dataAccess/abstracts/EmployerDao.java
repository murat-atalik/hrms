package findajob.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import findajob.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	@Query("From Employer where systemVerification=false")
	List<Employer> getUnconfirmed();

	@Query("From Employer where systemVerification=true")
	List<Employer> getConfirmed();
	
	Employer getById(int id);
	boolean existsEmployerByEmail(String email);
}
