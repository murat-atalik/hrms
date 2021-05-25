package findajob.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import findajob.hrms.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer>{
	boolean existsJobSeekerByNationalityId (String nationalityId);
	boolean existsJobSeekerByEmail (String email);
}
