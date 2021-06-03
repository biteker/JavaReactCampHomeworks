package kodlamaio.hrms.adapters;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CitizenService {
	
	Result isCitizen(Candidate candidate);
	
}
