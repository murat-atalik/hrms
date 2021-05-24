package findajob.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import findajob.hrms.business.abstracts.SystemPersonelService;
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
	public void add(SystemPersonel systemPersonel) {
		this.systemPersonelDao.save(systemPersonel);
		
	}

	@Override
	public List<SystemPersonel> getAll() {
		// TODO Auto-generated method stub
		return this.systemPersonelDao.findAll();
	}

}
