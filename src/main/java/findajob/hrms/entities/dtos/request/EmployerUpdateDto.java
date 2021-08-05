package findajob.hrms.entities.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerUpdateDto {
		private int employerId;
		private String email;
		private String phoneNumber;
		private String securityAnswer;
		
		
	}