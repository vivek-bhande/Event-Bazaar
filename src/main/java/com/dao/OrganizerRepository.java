package com.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.model.Admin;
import com.model.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
	
//	public List<Organizer> findByEmail(String email);
//	
//	public Organizer findByEmailAndOrganizerPass(String email, String organizerPass);
    @Query("SELECT o FROM Organizer o WHERE o.email = :email AND o.organizerPass = :password")
    Organizer findByEmailAndOrganizerPass(@Param("email") String email, @Param("password") String password);


}
