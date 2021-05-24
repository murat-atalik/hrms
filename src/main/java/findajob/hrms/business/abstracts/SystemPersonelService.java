package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.entities.concretes.SystemPersonel;

public interface SystemPersonelService {
	void add (SystemPersonel systemPersonel);
	List<SystemPersonel> getAll();
}
