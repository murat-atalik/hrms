package findajob.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import findajob.hrms.business.abstracts.FavoriteJobService;
import findajob.hrms.core.utilities.results.DataResult;
import findajob.hrms.core.utilities.results.Result;
import findajob.hrms.entities.concretes.FavoriteJob;
import findajob.hrms.entities.concretes.WorkProgram;
import findajob.hrms.entities.dtos.request.FavoriteJobDto;

@CrossOrigin
@RestController
@RequestMapping("api/favoriteJob")
public class FavoriteJobsController {
	private FavoriteJobService favoriteJobServie;
	@Autowired
	FavoriteJobsController(FavoriteJobService favoriteJobService){
		this.favoriteJobServie=favoriteJobService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody FavoriteJobDto favoriteJob) {
		return this.favoriteJobServie.add(favoriteJob);
	}
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.favoriteJobServie.delete(id);
	}
	@GetMapping("/getall")
	public DataResult<List<FavoriteJob>> getAll() {
		return this.favoriteJobServie.getAll();
	}
	@GetMapping("/getallbycandidateid")
	public DataResult<List<FavoriteJob>> getAllbyCAndidateId(@RequestParam int id) {
		return this.favoriteJobServie.getAllByCandidateId(id);
	}
	
}
