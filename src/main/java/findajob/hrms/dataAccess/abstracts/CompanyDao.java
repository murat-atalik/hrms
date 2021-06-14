package findajob.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import findajob.hrms.entities.concretes.Company;

public interface CompanyDao extends JpaRepository<Company, Integer> {
	Company getByCompanyName(String companyName);
	Company getByWebAddress(String webAddress);
}
