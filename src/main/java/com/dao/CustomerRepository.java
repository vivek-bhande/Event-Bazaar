package com.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.model.Customer;
import com.model.Organizer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
//	public List<Customer> findByEmail(String email);
	
//	public Customer findByEmailAndPassword(String email, String password);
	@Query("SELECT c FROM Customer c WHERE c.email = :email AND c.password = :password")
    Customer findByEmailAndPassword(@Param("email") String email, @Param("password") String password);


}
