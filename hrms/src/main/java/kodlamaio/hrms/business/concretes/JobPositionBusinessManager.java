package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.BusinessRuleService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionBusinessManager implements BusinessRuleService<JobPosition> {
	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionBusinessManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public Result verifyData(JobPosition data) {
		if(jobPositionDao.existsByName(data.getName()))
			return new ErrorResult("Job position already exists.");
		
		return new SuccessResult();
	}

}
