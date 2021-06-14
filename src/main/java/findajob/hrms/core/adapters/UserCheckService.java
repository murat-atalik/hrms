package findajob.hrms.core.adapters;


import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.dtos.request.CandidateDto;

public interface UserCheckService {
	 Result CheckIfRealPerson(CandidateDto candidate);
}
