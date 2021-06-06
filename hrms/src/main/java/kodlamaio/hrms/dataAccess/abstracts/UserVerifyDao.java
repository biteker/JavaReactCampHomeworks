package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.UserVerify;

public interface UserVerifyDao extends JpaRepository<UserVerify, Integer> {
	
	UserVerify getByVerifyCode(String verifyCode);
	boolean existsByVerifyCode(String verifyCode);

}
