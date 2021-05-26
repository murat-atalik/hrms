package findajob.hrms.core.adapters;


import java.sql.Date;

import org.springframework.stereotype.Component;

import findajob.hrms.core.utilities.ErrorResult;
import findajob.hrms.core.utilities.Result;
import findajob.hrms.core.utilities.SuccessResult;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Component
public class MernisServiceAdapter implements UserCheckService {

	@Override
	public Result CheckIfRealPerson(String nationalityId, String firstName, String lastName, Date dateOfBirthYear) {
		KPSPublicSoap soapClient = new KPSPublicSoapProxy();
		boolean check = false;
		
		try {
			 check = soapClient.TCKimlikNoDogrula(Long.parseLong(nationalityId), firstName.toUpperCase(),
					 lastName.toUpperCase(), dateOfBirthYear.getYear());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		if(check) {
			return new SuccessResult();
		}
		
		return new ErrorResult("Invalid nationalityId");
	}


}
