package findajob.hrms.entities.dtos.request;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto {
	private int id;
	private String schoolName;
	private Date startingDate;
	private Date graduationDate;	

}
