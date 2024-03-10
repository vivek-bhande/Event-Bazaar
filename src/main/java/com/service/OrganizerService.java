package com.service;

import java.util.List;

import com.model.Organizer;

public interface OrganizerService {

	public Organizer addOrganizer(Organizer o);
	
	public void deleteOrganizer(long organizerId);
	
	public List<Organizer> getAllOrganizer();
	
	public Organizer updateOrganizer(Organizer org);
	
//	public List<Organizer> findByEmail(String email);

	public Organizer registerOrganizer(Organizer organizer);
	 
    public Organizer loginOrganizer(String email, String organizerPass);

	public Organizer authenticateOrganizer(String email, String password);

}
