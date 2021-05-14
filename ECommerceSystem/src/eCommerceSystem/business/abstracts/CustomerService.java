package eCommerceSystem.business.abstracts;

import java.util.List;

import eCommerceSystem.entities.concretes.Customer;

public interface CustomerService {
	void add(Customer customer);
	void add(Customer[] customer);
	List<Customer> getAll();
}
