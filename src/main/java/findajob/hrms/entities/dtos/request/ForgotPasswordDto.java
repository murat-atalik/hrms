package findajob.hrms.entities.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForgotPasswordDto {

	
	private String securityAnswer;
	private String email;
	private String password;
	}


