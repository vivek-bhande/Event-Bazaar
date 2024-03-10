package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.EventCategory;

public interface EventCategoryRepository extends JpaRepository<EventCategory, Long> {

	public List<EventCategory> findByEventCategoryName (String eventCategoryName);

}
