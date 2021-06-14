package findajob.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import findajob.hrms.entities.concretes.Staff;

public interface StaffDao extends JpaRepository<Staff, Integer>{
	boolean existsStaffByEmail(String email);
}
