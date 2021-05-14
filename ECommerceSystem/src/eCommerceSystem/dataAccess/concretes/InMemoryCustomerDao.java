package eCommerceSystem.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceSystem.dataAccess.abstracts.CustomerDao;
import eCommerceSystem.entities.concretes.Customer;

public class InMemoryCustomerDao implements CustomerDao{
	
	private List<Customer> users = new ArrayList<Customer>();
	
	@Override
	public void add(Customer customer) {
		users.add(customer);
		System.out.println("Kayıt eklendi.");	
	}

	@Override
	public List<Customer> getAll() {
		return users;
	}
}
