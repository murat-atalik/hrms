package findajob.hrms.entities.dtos.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerAddDto {
	private int id;
		private String companyName;
		private String webAddress;
		private String email;
		private String password;
		private String rePassword;
		private String phoneNumber;
		private String securityAnswer;
		
		
	}

