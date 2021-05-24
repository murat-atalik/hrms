package findajob.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import findajob.hrms.business.abstracts.SystemPersonelService;
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
	public void add(@RequestBody SystemPersonel systemPersonel) {
		this.systemPersonelService.add(systemPersonel);
	}

	@GetMapping("/getall")
	public List<SystemPersonel> getAll() {
		return this.systemPersonelService.getAll();
	}

}
