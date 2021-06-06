package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ApproveEmployerService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class ApproveEmployerManager implements ApproveEmployerService {
	
	private EmployerDao employerDao;

	@Autowired
	public ApproveEmployerManager(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}

	@Override
	public Result approveEmployer(int id) {
		
		Employer approveEmployer = employerDao.getById(id);
		approveEmployer.setAdminApproval(true);
		employerDao.save(approveEmployer);
		return new SuccessResult("Employer approved.");
	}

}
