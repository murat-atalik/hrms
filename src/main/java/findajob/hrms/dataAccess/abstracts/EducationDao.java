package findajob.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import findajob.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer> {

}
