package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.FavoriteJob;
import findajob.hrms.entities.dtos.request.FavoriteJobDto;

public interface FavoriteJobService {
	
	Result add(FavoriteJobDto favoriteJob);
	Result delete(int id);
	Result update(FavoriteJobDto favoriteJob);
	DataResult<List<FavoriteJob>> getAll();
	DataResult<List<FavoriteJob>> getAllByCandidateId(int id);
}
