package com.service;

import java.util.List;

import com.model.Event;

public interface EventService {

    public Event addEvent(Event e);
	
	public void cancelEvent(long eventId);
	
	public List<Event> getAllEvent();
	
	public Event updateEvent(Event e);
	
	public List<Event>findByEventName(String eventName);
	
	public Event getOneEvent(long eventId);
}
