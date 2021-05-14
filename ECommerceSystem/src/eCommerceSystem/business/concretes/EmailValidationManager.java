package eCommerceSystem.business.concretes;

import java.util.regex.Pattern;

import eCommerceSystem.business.abstracts.ValidationService;
import eCommerceSystem.entities.concretes.Customer;

public class EmailValidationManager implements ValidationService {

	@Override
	public boolean validate(Customer customer) {
		final Pattern MAIL_FORMAT = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
		
		if(MAIL_FORMAT.matcher(customer.getEmail()).find())
			return true;
		return false;
	}
}
