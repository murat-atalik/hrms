package findajob.hrms.entities.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffUpdateDto {
	private int id;
	private String email;
	private String firstName;
	private String lastName;
	private int roleId;


}
