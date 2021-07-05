package findajob.hrms.entities.dtos.request;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceDto {
	private int id;
	private String businessName;
	private String position;
	private Date startingDate;
	private Date quitDate;
}
