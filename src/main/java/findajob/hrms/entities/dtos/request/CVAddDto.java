package findajob.hrms.entities.dtos.request;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CVAddDto {
	
	private int candidateId;
	private String firstName;
	private String lastName;
	private String email;
	private String coverLetter;
	private String github;
	private String linkedin;
	private String imageUrl;
	
	private List<EducationDto> educations;
	
	private List<ExperienceDto> experiences;
	
	private List<LanguageDto> languages;
	
	private List<AbilityDto> abilities;
	

}

