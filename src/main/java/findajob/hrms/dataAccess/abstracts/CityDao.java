package findajob.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import findajob.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {
	City getById(int id);
}
