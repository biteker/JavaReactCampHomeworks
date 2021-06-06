package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ApproveEmployerService;
import kodlamaio.hrms.business.abstracts.UserVerifyService;
import kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/verify")
public class UserVerifyController {
	
	private UserVerifyService userVerifyService;
	private ApproveEmployerService approveEmployerService;

	@Autowired
	public UserVerifyController(UserVerifyService userVerifyService, ApproveEmployerService approveEmployerService) {
		this.userVerifyService = userVerifyService;
		this.approveEmployerService = approveEmployerService;
	}
	
	@PutMapping("/candidate/{verifyCode}")
	public Result verifyCode(@PathVariable("verifyCode") String verifyCode) {
		return userVerifyService.verifyUser(verifyCode);
	}
	
	@PutMapping("/employer/{employerId}")
	public Result approveEmployer(@PathVariable("employerId") int id) {
		return approveEmployerService.approveEmployer(id);
		//return null;
	}

}
