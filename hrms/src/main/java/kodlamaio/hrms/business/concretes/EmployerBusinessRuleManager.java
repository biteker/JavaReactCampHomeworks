package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.BusinessRuleService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerBusinessRuleManager implements BusinessRuleService<Employer> {

	@Override
	public Result verifyData(Employer employer) {
		
		String[] mailDomain = employer.getEmail().split("@");
		if(!mailDomain[1].equals(employer.getWeb()))
			return new ErrorResult("The email is not in the company domain.");
		
		return new SuccessResult();
	}

}
