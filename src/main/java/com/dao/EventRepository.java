package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
	
	public List<Event> findByEventName(String eventName);

}
