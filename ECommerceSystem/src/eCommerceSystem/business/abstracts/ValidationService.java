package eCommerceSystem.business.abstracts;

import eCommerceSystem.entities.concretes.Customer;

public interface ValidationService {
	boolean validate(Customer customer);

}
