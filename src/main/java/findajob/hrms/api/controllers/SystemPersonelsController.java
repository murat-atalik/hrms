package findajob.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import findajob.hrms.business.abstracts.SystemPersonelService;
import findajob.hrms.core.utilities.DataResult;
import findajob.hrms.core.utilities.Result;
import findajob.hrms.entities.concretes.SystemPersonel;

@RestController
@RequestMapping("api/systempersonel")
public class SystemPersonelsController {

	private SystemPersonelService systemPersonelService;

	@Autowired
	public SystemPersonelsController(SystemPersonelService systemPersonelService) {
		this.systemPersonelService = systemPersonelService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody SystemPersonel systemPersonel) {
		return this.systemPersonelService.add(systemPersonel);
	}

	@GetMapping("/getall")
	public DataResult<List<SystemPersonel>> getAll() {
		return this.systemPersonelService.getAll();
	}

}
