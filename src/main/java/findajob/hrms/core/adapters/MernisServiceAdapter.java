package findajob.hrms.core.adapters;



import java.rmi.RemoteException;

import org.springframework.stereotype.Component;

import findajob.hrms.core.utilities.results.ErrorResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.core.utilities.results.SuccessResult;
import findajob.hrms.entities.concretes.Candidate;
import findajob.hrms.entities.dtos.request.CandidateDto;


@Component
public class MernisServiceAdapter implements UserCheckService {

	@Override
	public Result CheckIfRealPerson(CandidateDto candidate) {
		// TODO Auto-generated method stub
		return null;
	}

	//Kimlik doğrulama sistemi çalışmamaktadır
	/*@Override
	public Result CheckIfRealPerson(CandidateDto candidate) {
		KPSPublicSoap soapClient = new KPSPublicSoapProxy();
		boolean check = false;
		
		try {
			 check = soapClient.TCKimlikNoDogrula(Long.parseLong(candidate.getNationalityId()), candidate.getFirstName().toUpperCase(),
					 candidate.getLastName().toUpperCase(),candidate.getBirthday().getYear());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(check) {
		}
		
		return new ErrorResult("Invalid nationlity id");
		
		};*/
	}
