package com.service;

import java.util.List;

import com.model.EventCategory;

public interface EventCategoryService {
	
    public EventCategory addEvent_Catagory(EventCategory ec);
	
	public EventCategory getOneEvent__Catagory(long eventCategoryId);
	
	public List<EventCategory>getAllEvent_Catagory();
	
	public EventCategory updateEvent_Catagory(EventCategory ec);
	
	public void deleteEvent_Catagory(long eventCategoryId);
	
	public List<EventCategory>findByEventCategoryName(String eventCategoryName);

}
