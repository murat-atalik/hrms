package findajob.hrms.entities.dtos.request;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateUpdateDto {
	private int candidateId;
	private String email;
	private String firstName;
	private String lastName;	
	private Date birthday;
	private String securityAnswer;
}
