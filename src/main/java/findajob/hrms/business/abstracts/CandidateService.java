package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.Candidate;
import findajob.hrms.entities.dtos.CandidateDto;

public interface CandidateService {
	Result add(CandidateDto candidate);
	DataResult<List<Candidate>> getAll();
	DataResult<Candidate> getById(int id);
}
