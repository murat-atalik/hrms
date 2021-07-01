package findajob.hrms.entities.dtos.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertFilter {
	    private List<Integer> cityId;
	    private List<Integer> jobPositionId;
	    private List<Integer> workTypeId;
	    private List<Integer> workProgramId;
	
}
