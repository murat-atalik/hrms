package findajob.hrms.business.abstracts;

import java.sql.Date;

public interface UserCheckService {
	 boolean CheckIfRealPerson(String nationalityId, String firstName, String lastName, Date dateOfBirthYear);
}
