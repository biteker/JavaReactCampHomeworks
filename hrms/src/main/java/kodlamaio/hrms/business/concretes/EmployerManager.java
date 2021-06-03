package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.BusinessRuleService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements UserService<Employer> {
	private EmployerDao employerDao;
	private BusinessRuleService<Employer> businessRuleService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, BusinessRuleService<Employer> businessRuleService) {
		super();
		this.employerDao = employerDao;
		this.businessRuleService = businessRuleService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"Employer successfully listed");
	}

	@Override
	public Result add(Employer employer) {
		Result business = businessRuleService.verifyData(employer);
		if(!business.isSuccess())
			return new ErrorResult(business.getMessage());
		
		employerDao.save(employer);
		return new SuccessResult("Employer added.");
	}

}
