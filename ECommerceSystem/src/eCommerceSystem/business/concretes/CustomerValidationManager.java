package eCommerceSystem.business.concretes;

import java.util.List;

import eCommerceSystem.business.abstracts.ValidationService;
import eCommerceSystem.entities.concretes.Customer;

public class CustomerValidationManager implements ValidationService {

	@Override
	public boolean validate(Customer customer) {
		if (customer.getName()==null) {
			System.out.println("İsim alanı boş olamaz.");
			return false;
		}
		if (customer.getSurname()==null) {
			System.out.println("Soyad alanı boş olamaz.");
			return false;
		}
		if (customer.getPassword()==null) {
			System.out.println("Şifre alanı boş olamaz.");
			return false;
		}
		if (customer.getEmail() == null) {
			System.out.println("E-posta alanı boş olmaz.");
			return false;
		}
		if (customer.getPassword().length()<6) {
			System.out.println("Parola alanı en az 6 karakterden oluşmalıdır.");
			return false;
		}
		if (customer.getName().length()<2) {
			System.out.println("İsim iki karakterden az olamaz.");
			return false;
		}
		if (customer.getSurname().length()<2) {
			System.out.println("Soyad iki karakterden az olmaz");
			return false;
		}
		return true;
	}

}
