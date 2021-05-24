package findajob.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.SystemPersonelService;
import findajob.hrms.core.utilities.DataResult;
import findajob.hrms.core.utilities.Result;
import findajob.hrms.core.utilities.SuccessDataResult;
import findajob.hrms.core.utilities.SuccessResult;
import findajob.hrms.dataAccess.abstracts.SystemPersonelDao;
import findajob.hrms.entities.concretes.SystemPersonel;
@Service
public class SystemPersonelManager implements SystemPersonelService {

	private SystemPersonelDao systemPersonelDao;
	
	@Autowired
	public SystemPersonelManager(SystemPersonelDao systemPersonelDao) {
		this.systemPersonelDao=systemPersonelDao;
	}
	
	@Override
	public Result add(SystemPersonel systemPersonel) {
		this.systemPersonelDao.save(systemPersonel);
		return new SuccessResult("System personel addedd");
	}

	@Override
	public DataResult<List<SystemPersonel>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<SystemPersonel>>(this.systemPersonelDao.findAll(),"System personel listed");
	}

}
