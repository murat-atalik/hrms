package findajob.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import findajob.hrms.entities.concretes.Ability;

public interface AbilityDao extends JpaRepository<Ability, Integer>{
	
}
