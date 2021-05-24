package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.core.utilities.DataResult;
import findajob.hrms.core.utilities.Result;
import findajob.hrms.entities.concretes.SystemPersonel;

public interface SystemPersonelService {
	Result add (SystemPersonel systemPersonel);
	DataResult<List<SystemPersonel>> getAll();
}
