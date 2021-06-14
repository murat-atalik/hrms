package findajob.hrms.business.abstracts;

import java.util.List;

import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.City;

public interface CityService {
	Result add(City city);
	DataResult<List<City>> getAll();
	DataResult<City> getByPlateNumber(String plateNumber);
}
