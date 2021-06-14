package findajob.hrms.entities.dtos.response;


import findajob.hrms.entities.concretes.Ability;
import findajob.hrms.entities.concretes.Education;
import findajob.hrms.entities.concretes.Experience;
import findajob.hrms.entities.concretes.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CVResponseDto {
	private int candidateId;
	private String coverLetter;
	private String github;
	private String linkedin;
	private String imageUrl;
	
	private Education[] educations;
	private Experience[] experiences;
	private Language[] languages;	
	private Ability[] abilities;
}
