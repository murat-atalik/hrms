package findajob.hrms.core.adapters;



import org.springframework.stereotype.Component;

import findajob.hrms.core.utilities.results.ErrorResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.core.utilities.results.SuccessResult;
import findajob.hrms.entities.concretes.Candidate;
import findajob.hrms.entities.dtos.CandidateDto;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Component
public class MernisServiceAdapter implements UserCheckService {
	
	@Override
	public Result CheckIfRealPerson(CandidateDto candidate) {
		KPSPublicSoapProxy soapClient = new KPSPublicSoapProxy();
		boolean check = false;
		try {
			 check = soapClient.TCKimlikNoDogrula(Long.parseLong(candidate.getNationalityId()), candidate.getFirstName().toUpperCase(),
					 candidate.getLastName().toUpperCase(),candidate.getBirthday().getYear());
		} catch (Exception e) {
			e.printStackTrace();
		} 

		if(check) {
			return new SuccessResult();
		}
		
		return new ErrorResult("Invalid nationalityId");
	}

}
