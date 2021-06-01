package findajob.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.StaffService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.core.utilities.results.SuccessDataResult;
import findajob.hrms.core.utilities.results.SuccessResult;
import findajob.hrms.dataAccess.abstracts.StaffDao;
import findajob.hrms.entities.concretes.Staff;
@Service
public class StaffManager implements StaffService {

	private StaffDao staffDao;
	
	@Autowired
	public StaffManager(StaffDao staffDao) {
		this.staffDao=staffDao;
	}
	
	@Override
	public Result add(Staff staff) {
		this.staffDao.save(staff);
		return new SuccessResult("System personel addedd");
	}

	@Override
	public DataResult<List<Staff>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Staff>>(this.staffDao.findAll(),"System personel listed");
	}

}
