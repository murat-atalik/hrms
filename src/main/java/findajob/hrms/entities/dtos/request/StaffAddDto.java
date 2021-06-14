package findajob.hrms.entities.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffAddDto {
	private String email;
	private String firstName;
	private String lastName;
	private String roleName;
	private String password;
	private String rePassword;
	
	
}
