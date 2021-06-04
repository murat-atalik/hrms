package findajob.hrms.core.adapters;

import java.sql.Date;

import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.Candidate;
import findajob.hrms.entities.dtos.CandidateDto;

public interface UserCheckService {
	 Result CheckIfRealPerson(CandidateDto candidate);
}
