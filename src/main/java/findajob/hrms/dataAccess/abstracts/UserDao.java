package findajob.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import findajob.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
