package findajob.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import findajob.hrms.entities.concretes.FavoriteJob;

public interface FavoriteJobDao extends JpaRepository<FavoriteJob, Integer> {
	FavoriteJob getById(int id);
	List<FavoriteJob> getAllByCandidateId(int id);
	List<FavoriteJob> getAllByJobAdvertisementId(int id);
	
	@Query("From FavoriteJob where candidate.id=:candidateId and jobAdvertisement.id=:jobAdvertId")
	List<FavoriteJob> findFavoriteJob(int candidateId,int jobAdvertId);
	
}
