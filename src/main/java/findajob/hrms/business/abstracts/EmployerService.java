package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.entities.concretes.Employer;

public interface EmployerService {
	void add(Employer employer);
	List<Employer> getAll();
	
}
