package findajob.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import findajob.hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae, Integer> {

	List<CurriculumVitae> getByCandidateId(int id);
	@Query("From CurriculumVitae where active=true and candidate.id=:id")
	CurriculumVitae getByCandidateIdActive(int id);

	@Query("From CurriculumVitae where active=false and candidate.id=:id")
	List<CurriculumVitae> getByCandidateIdPassive(int id);
	CurriculumVitae getById(int id);
}
