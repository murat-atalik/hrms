package findajob.hrms.entities.dtos.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageDto {
	private int id;
	private String language;
	@Min(1)
	@Max(5)
	private int degree;
}
