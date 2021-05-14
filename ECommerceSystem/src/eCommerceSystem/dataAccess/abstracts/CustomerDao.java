package eCommerceSystem.dataAccess.abstracts;

import java.util.List;

import eCommerceSystem.entities.concretes.Customer;

public interface CustomerDao {
	void add(Customer customer);
	List<Customer> getAll();

}
