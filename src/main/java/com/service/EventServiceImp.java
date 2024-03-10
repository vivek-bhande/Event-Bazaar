package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EventRepository;
import com.model.Event;

@Service
public class EventServiceImp implements EventService {

	@Autowired
	EventRepository eventRepo;
	
	@Override
	public Event addEvent(Event e) {
		return eventRepo.save(e);
	}

	@Override
	public void cancelEvent(long eventId) {
		eventRepo.deleteById(eventId);

	}

	@Override
	public List<Event> getAllEvent() {
		return eventRepo.findAll();
	}

	@Override
	public Event updateEvent(Event e) {
		Event event=eventRepo.findById(e.getEventId()).orElse(null);
		event.setEventName(e.getEventName());
		event.setLocation(e.getLocation());
		event.setPeopleCapacity(e.getPeopleCapacity());
		return eventRepo.save(event);
	}

	@Override
	public List<Event> findByEventName(String eventName) {
		return eventRepo.findByEventName(eventName);
	}

	@Override
	public Event getOneEvent(long eventId) {
		return eventRepo.findById(eventId).orElse(null);

	}

}
