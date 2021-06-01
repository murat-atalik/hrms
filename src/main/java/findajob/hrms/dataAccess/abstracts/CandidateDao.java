package findajob.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import findajob.hrms.entities.concretes.Candidate;
import findajob.hrms.entities.concretes.User;


public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	boolean existsCandidateByNationalityId (String nationalityId);
	boolean existsCandidateByEmail (String email);
	User getByNationalityId(String nationlityId);
	Candidate getById(int id);
}
