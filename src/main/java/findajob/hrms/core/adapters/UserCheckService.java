package findajob.hrms.core.adapters;

import java.sql.Date;

import findajob.hrms.core.utilities.Result;

public interface UserCheckService {
	 Result CheckIfRealPerson(String nationalityId, String firstName, String lastName, Date dateOfBirthYear);
}
