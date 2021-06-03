package kodlamaio.hrms.adapters;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

@Service
public class FakeMernisServiceAdapter implements CitizenService {

	@Override
	public Result isCitizen(Candidate candidate) {
		// TODO Auto-generated method stub
		//return new ErrorResult("Candidate is not a citizen");
		return new SuccessResult();
	}

}
