package findajob.hrms.entities.dtos.request;

import java.sql.Date;

import javax.validation.constraints.Email;

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
