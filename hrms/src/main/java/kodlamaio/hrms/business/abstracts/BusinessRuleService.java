package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

public interface BusinessRuleService<T> {
	
	Result verifyData(T data);

}
