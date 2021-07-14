package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.Staff;
import findajob.hrms.entities.dtos.request.StaffAddDto;
import findajob.hrms.entities.dtos.request.StaffUpdateDto;


public interface StaffService {
	Result add (StaffAddDto staff);
	Result update (StaffUpdateDto staff);
	DataResult<List<Staff>> getAll();
	DataResult<Staff> getById(int id);
}
