package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.BusinessRuleService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.UserVerifyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements UserService<Candidate> {
	@Autowired
	private CandidateDao candidateDao;
	private BusinessRuleService<Candidate> businessRuleService;
	private UserVerifyService userVerifyService;
	private UserDao userDao;

	
	public CandidateManager(CandidateDao candidateDao, 
			BusinessRuleService<Candidate> businessRuleService, 
			UserVerifyService userVerifyService,
			UserDao userDao) {
		this.candidateDao = candidateDao;
		this.businessRuleService = businessRuleService;
		this.userVerifyService = userVerifyService;
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(),"Candidates successfully listed.");
	}

	@Override
	public Result add(Candidate candidate) {
		
		Result business = businessRuleService.verifyData(candidate);

		if (!business.isSuccess()) {
			return new ErrorResult(business.getMessage());
		}
		candidateDao.save(candidate);
		userVerifyService.genarateVerifyCode(userDao.getOne(candidate.getId()));
		userVerifyService.sendMail(candidate.getEmail());
		
		return new SuccessResult("Candidate added.");
	}

}
