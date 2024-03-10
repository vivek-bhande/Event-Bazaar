	package com.service;
	
	import java.util.List;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	
	import com.dao.CustomerRepository;
	import com.model.Customer;
	
	@Service
	public class CustomerServiceImp implements CustomerService {
	
		
		@Autowired
		CustomerRepository cusRepo;
		
		@Override
		public Customer addCustomer(Customer c) {
			return cusRepo.save(c);
		}
	
		@Override
		public void deleteCustomer(long customerId) {
			cusRepo.deleteById(customerId);
	
		}
	
		@Override
		public Customer updateCustomer(Customer cs) {
			Customer custo=cusRepo.findById(cs.getCustomerId()).orElse(null);
			custo.setCustomerName(cs.getCustomerName());
			custo.setEmail(cs.getEmail());
			return cusRepo.save(custo);
		}
	
		@Override
		public List<Customer> getAll() {
			return cusRepo.findAll();
		}
	
		@Override
		public Customer getOneCustomer(long customerId) {
			return cusRepo.findById(customerId).orElse(null);
		}
	
//		@Override
//		public List<Customer> findByEmail(String email) {
//			// TODO Auto-generated method stub
//			return cusRepo.findByEmail(email);
//		}
		public Customer authenticateCustomer(String email, String password) {
	        return cusRepo.findByEmailAndPassword(email, password);
	    }
		

		@Override
		public Customer registerCustomer(Customer customer) {
			return cusRepo.save(customer);
		}

		@Override
		public Customer loginCustomer(String email, String password) {
			return cusRepo.findByEmailAndPassword(email, password);
		}

		
	
	}
