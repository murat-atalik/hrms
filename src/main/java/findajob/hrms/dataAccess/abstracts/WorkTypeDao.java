package findajob.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import findajob.hrms.entities.concretes.WorkType;

public interface WorkTypeDao extends JpaRepository<WorkType, Integer>{

}
