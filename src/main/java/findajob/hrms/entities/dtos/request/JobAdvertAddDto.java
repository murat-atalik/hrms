package findajob.hrms.entities.dtos.request;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertAddDto {

	private int id;
	private String jobDescription;
	private double minSalary;
	private double maxSalary;
	private int openPosition;
	private boolean remote;
	private Date applicationDeadline;
	private boolean active;

	private int employerId;

	private int workProgramId;

	private int jobPositionId;

	private String cityPlatenumber;
}
