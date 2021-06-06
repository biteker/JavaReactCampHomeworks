package kodlamaio.hrms.business.concretes;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserVerifyService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserVerifyDao;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.UserVerify;

@Service
public class UserVerifyManager implements UserVerifyService {
	
	private UserVerifyDao userVerifyDao;

	@Autowired
	public UserVerifyManager(UserVerifyDao userVerifyDao) {
		this.userVerifyDao = userVerifyDao;
	}

	@Override
	public Result verifyUser(String verifyCode) {
		
		if(!userVerifyDao.existsByVerifyCode(verifyCode))
			return new ErrorResult("The verification code is incorrect.");
		
		UserVerify newUser = userVerifyDao.getByVerifyCode(verifyCode);
		if(userVerifyDao.getOne(newUser.getId()).isConfirmed())
			return new ErrorResult("Verification already done.");
		
		
		newUser.setConfirmed(true);
		userVerifyDao.save(newUser);
		
		return new SuccessResult("Verification successful.");
	}

	@Override
	public void genarateVerifyCode(User user) {
		UserVerify userVerify = new UserVerify();
		userVerify.setUserId(user);
		userVerify.setVerifyCode(UUID.randomUUID().toString());
		userVerifyDao.save(userVerify);
	}

	@Override
	public void sendMail(String email) {
		System.out.println("Email sent: " + email);
	}

}
