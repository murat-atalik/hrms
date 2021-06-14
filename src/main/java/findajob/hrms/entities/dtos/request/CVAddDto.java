package findajob.hrms.entities.dtos.request;

import java.sql.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CVAddDto {
	private int candidateId;
	private String coverLetter;
	private String github;
	private String linkedin;
	private String imageUrl;
	
	private String schoolName;
	private Date educationStartDate;
	private Date graduationDate;	
	
	private String businessName;
	private Date workStartDate;
	private Date workQuitDate;
	
	private String languageName;
	@Min(1)
	@Max(5)
	private int languageDegree;
	
	private String ability;
}
