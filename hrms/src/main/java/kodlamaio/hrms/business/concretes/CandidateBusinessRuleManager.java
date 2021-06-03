package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.adapters.CitizenService;
import kodlamaio.hrms.business.abstracts.BusinessRuleService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateBusinessRuleManager implements BusinessRuleService<Candidate> {
	
	private CitizenService citizenService;
	private UserDao userDao;
	private CandidateDao candidateDao;

	@Autowired
	public CandidateBusinessRuleManager(CitizenService citizenService, UserDao userDao, CandidateDao candidateDao) {
		super();
		this.citizenService = citizenService;
		this.userDao = userDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public Result verifyData(Candidate candidate) {
		
		Result citizen = citizenService.isCitizen(candidate);
		if(!citizen.isSuccess())
			return new ErrorResult(citizen.getMessage());
		
		if(userDao.existsByEmail(candidate.getEmail()))
			return new ErrorResult("E-mail registered. Try another e-mail address.");
		
		if(candidateDao.existsByIdentityNumber(candidate.getIdentityNumber()))
			return new ErrorResult("Identity number registered. Try another identity number.");
		
		if (!candidate.getPassword().equals(candidate.getPasswordRepeat()))
			return new ErrorResult("Passwords do not match");
		
		return new SuccessResult("Business rules passed.");
	}
}
