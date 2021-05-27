package findajob.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import findajob.hrms.entities.concretes.Candidate;


public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	boolean existsCandidateByNationalityId (String nationalityId);
	boolean existsCandidateByEmail (String email);
}
