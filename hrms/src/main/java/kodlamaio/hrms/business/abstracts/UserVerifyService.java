package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.User;

public interface UserVerifyService {
	Result verifyUser(String verifyCode);
	void genarateVerifyCode(User user);
	void sendMail(String email);

}
