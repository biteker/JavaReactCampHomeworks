package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.BusinessRuleService;
import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	
	private JobPositionDao jobPositionDao;
	private BusinessRuleService<JobPosition> businessRuleService;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao,BusinessRuleService<JobPosition> businessRuleService) {
		this.jobPositionDao = jobPositionDao;
		this.businessRuleService = businessRuleService;
	}

	@Override
	public List<JobPosition> getAll() {
		return jobPositionDao.findAll();
	}

	@Override
	public Result add(JobPosition jobPosition) {
		
		Result business = businessRuleService.verifyData(jobPosition);
		if(!business.isSuccess())
			return new ErrorResult(business.getMessage());
		
		jobPositionDao.save(jobPosition);
		
		return new SuccessResult("Job position added");
	}

}
