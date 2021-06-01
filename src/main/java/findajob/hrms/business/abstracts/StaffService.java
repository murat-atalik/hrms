package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.Staff;


public interface StaffService {
	Result add (Staff staff);
	DataResult<List<Staff>> getAll();
}
