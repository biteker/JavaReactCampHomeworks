package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.BusinessRuleService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerBusinessRuleManager implements BusinessRuleService<Employer> {
	private UserDao userDao;

	@Autowired
	public EmployerBusinessRuleManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Result verifyData(Employer employer) {
		
		String[] mailDomain = employer.getEmail().split("@");
		if(!mailDomain[1].equals(employer.getWeb()))
			return new ErrorResult("The email is not in the company domain.");
		
		if(userDao.existsByEmail(employer.getEmail()))
			return new ErrorResult("E-mail registered. Try another e-mail address.");
		
		if (!employer.getPassword().equals(employer.getPasswordRepeat()))
			return new ErrorResult("Passwords do not match");
		
		return new SuccessResult();
	}

}
