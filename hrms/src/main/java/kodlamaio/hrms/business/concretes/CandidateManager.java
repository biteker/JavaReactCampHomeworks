package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.adapters.CitizenService;
import kodlamaio.hrms.business.abstracts.BusinessRuleService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements UserService<Candidate> {
	@Autowired
	private CandidateDao candidateDao;
	private BusinessRuleService<Candidate> businessRuleService;

	
	public CandidateManager(CandidateDao candidateDao, BusinessRuleService<Candidate> businessRuleService) {
		super();
		this.candidateDao = candidateDao;
		this.businessRuleService = businessRuleService;
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
		return new SuccessResult("Candidate added.");
	}

}
