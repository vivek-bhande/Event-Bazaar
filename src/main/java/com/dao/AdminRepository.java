package com.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.model.Admin;
import com.model.Event;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	
//	public List<Admin> findByEmail(String email);
//
//	public Admin findByEmailAndPassword(String email, String password);
	
	@Query("SELECT a FROM Admin a WHERE a.email = :email AND a.password = :password")
    Admin findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}
