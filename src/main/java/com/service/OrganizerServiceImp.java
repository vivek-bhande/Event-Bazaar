package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.OrganizerRepository;
import com.model.Organizer;

@Service
public class OrganizerServiceImp implements OrganizerService {

	@Autowired
	OrganizerRepository orgRepo;
	
	@Override
	public Organizer addOrganizer(Organizer o) {
		return orgRepo.save(o);
	}

	@Override
	public void deleteOrganizer(long organizerId) {
		orgRepo.deleteById(organizerId);

	}

	@Override
	public List<Organizer> getAllOrganizer() {
		return orgRepo.findAll();
	}

	@Override
	public Organizer updateOrganizer(Organizer org) {
		Organizer or=orgRepo.findById(org.getOrganizerId()).orElse(null);
		or.setOrganizerName(org.getOrganizerName());
		or.setOrganizerPass(org.getOrganizerPass());
		return orgRepo.save(org);
	}

//	@Override
//	public List<Organizer> findByEmail(String email) {
//		// TODO Auto-generated method stub
//		return orgRepo.findByEmail(email);
//	}
	public Organizer authenticateOrganizer(String email, String password) {
        return orgRepo.findByEmailAndOrganizerPass(email, password);
    }

	@Override
	public Organizer registerOrganizer(Organizer organizer) {
		// TODO Auto-generated method stub
		return orgRepo.save(organizer);
	}

	@Override
	public Organizer loginOrganizer(String email, String organizerPass) {
		// TODO Auto-generated method stub
		return orgRepo.findByEmailAndOrganizerPass(email, organizerPass);
	}

	

}
