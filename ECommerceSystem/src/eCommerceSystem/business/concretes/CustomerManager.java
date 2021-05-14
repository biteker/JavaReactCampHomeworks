package eCommerceSystem.business.concretes;

import java.util.List;

import eCommerceSystem.business.abstracts.CustomerService;
import eCommerceSystem.business.abstracts.ValidationService;
import eCommerceSystem.dataAccess.abstracts.CustomerDao;
import eCommerceSystem.entities.concretes.Customer;

public class CustomerManager implements CustomerService {
	private CustomerDao customerDao;
	private ValidationService[] validationService;

	public CustomerManager(CustomerDao customerDao,ValidationService[] validationService) {
		this.customerDao = customerDao;
		this.validationService = validationService;
	}

	@Override
	public void add(Customer customer) {

		for (ValidationService validation : validationService) {
			if (!validation.validate(customer)) {
				System.out.println("Doğrulama Hatası:");
				return;
			}
		}
			customerDao.add(customer);
	}
	
	@Override
	public void add(Customer[] customers) {
		for (Customer customer : customers) {
			add(customer);
		}
		
	}
	@Override
	public List<Customer> getAll() {
		return customerDao.getAll();
	}



}