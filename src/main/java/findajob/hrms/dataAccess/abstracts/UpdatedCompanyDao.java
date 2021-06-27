package findajob.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import findajob.hrms.entities.concretes.UpdatedCompany;

public interface UpdatedCompanyDao extends JpaRepository<UpdatedCompany, Integer>{
	UpdatedCompany getById(int id);
	UpdatedCompany getByEmployerId(int id);
	UpdatedCompany getByCompanyId(int id);
}
