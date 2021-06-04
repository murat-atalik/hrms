package findajob.hrms.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDto {
	private int id;
	private String email;
	private String password;
	private String rePassword;
	private String firstName;
	private String lastName;	
	private Date birthday;
	private String nationalityId;

}
