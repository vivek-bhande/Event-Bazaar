package com.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class EventCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long eventCategoryId;
	private String eventCategoryName;
	
	@OneToMany(fetch = FetchType.EAGER)
	public List<Event> event;

	public EventCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EventCategory(long eventCategoryId, String eventCategoryName, List<Event> event) {
		super();
		this.eventCategoryId = eventCategoryId;
		this.eventCategoryName = eventCategoryName;
		this.event = event;
	}

	public long getEventCategoryId() {
		return eventCategoryId;
	}

	public void setEventCategoryId(long eventCategoryId) {
		this.eventCategoryId = eventCategoryId;
	}

	public String getEventCategoryName() {
		return eventCategoryName;
	}

	public void setEventCategoryName(String eventCategoryName) {
		this.eventCategoryName = eventCategoryName;
	}

	public List<Event> getEvent() {
		return event;
	}

	public void setEvent(List<Event> event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "EventCategory [eventCategoryId=" + eventCategoryId + ", eventCategoryName=" + eventCategoryName
				+ ", event=" + event + "]";
	}
	
	

}
