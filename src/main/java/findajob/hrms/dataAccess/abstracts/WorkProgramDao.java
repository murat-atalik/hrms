package findajob.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import findajob.hrms.entities.concretes.WorkProgram;

public interface WorkProgramDao extends JpaRepository<WorkProgram, Integer> {

}
