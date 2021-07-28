package findajob.hrms.entities.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertAppliesDto {
	private int candidateId;
	private int jobAdvertisementId;

}
