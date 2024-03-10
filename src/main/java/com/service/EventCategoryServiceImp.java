package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EventCategoryRepository;
import com.model.EventCategory;

@Service
public class EventCategoryServiceImp implements EventCategoryService {

	@Autowired
	EventCategoryRepository evecataRepo;
	
	@Override
	public EventCategory addEvent_Catagory(EventCategory ec) {
		return evecataRepo.save(ec);
	}

	@Override
	public EventCategory getOneEvent__Catagory(long eventCategoryId) {
		return evecataRepo.findById(eventCategoryId).orElse(null);
	}

	@Override
	public List<EventCategory> getAllEvent_Catagory() {
		return evecataRepo.findAll();
	}

	@Override
	public EventCategory updateEvent_Catagory(EventCategory ec) {
		EventCategory existingevecat=evecataRepo.findById(ec.getEventCategoryId()).orElse(null);
		existingevecat.setEventCategoryName(ec.getEventCategoryName());
		return evecataRepo.save(ec);
	}

	@Override
	public void deleteEvent_Catagory(long eventCategoryId) {
		evecataRepo.deleteById(eventCategoryId);

	}

	@Override
	public List<EventCategory> findByEventCategoryName(String eventCategoryName) {
		return evecataRepo.findByEventCategoryName(eventCategoryName);
	}

}
