package findajob.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import findajob.hrms.entities.concretes.Role;

public interface RoleDao extends JpaRepository<Role, Integer>{

}
