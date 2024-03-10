package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.EventCategory;
import com.service.EventCategoryService;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/eventcategories")
public class EventCategoryController {

    @Autowired
    private EventCategoryService eventCategoryService;

    @PostMapping("/addeventcat")
    public ResponseEntity<EventCategory> addEventCategory(@RequestBody EventCategory ec) {
        EventCategory createdEventCategory = eventCategoryService.addEvent_Catagory(ec);
        return new ResponseEntity<>(createdEventCategory, HttpStatus.CREATED);
    }

    @GetMapping("/geteventcat/{id}")
    public ResponseEntity<EventCategory> getEventCategory(@PathVariable("id") long eventCategoryId) {
        EventCategory eventCategory = eventCategoryService.getOneEvent__Catagory(eventCategoryId);
        if (eventCategory != null) {
            return new ResponseEntity<>(eventCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getalleventcat")
    public ResponseEntity<List<EventCategory>> getAllEventCategories() {
        List<EventCategory> eventCategories = eventCategoryService.getAllEvent_Catagory();
        return new ResponseEntity<>(eventCategories, HttpStatus.OK);
    }

    @PutMapping("/updateeventcat/{id}")
    public ResponseEntity<EventCategory> updateEventCategory(@PathVariable("id") long eventCategoryId, @RequestBody EventCategory ec) {
        EventCategory existingEventCategory = eventCategoryService.getOneEvent__Catagory(eventCategoryId);
        if (existingEventCategory != null) {
            ec.setEventCategoryId(eventCategoryId);
            EventCategory updatedEventCategory = eventCategoryService.updateEvent_Catagory(ec);
            return new ResponseEntity<>(updatedEventCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteventcat/{id}")
    public ResponseEntity<Void> deleteEventCategory(@PathVariable("id") long eventCategoryId) {
        EventCategory existingEventCategory = eventCategoryService.getOneEvent__Catagory(eventCategoryId);
        if (existingEventCategory != null) {
            eventCategoryService.deleteEvent_Catagory(eventCategoryId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getbynameeventcat/search/{name}")
    public ResponseEntity<List<EventCategory>> findByEventCategoryName(@PathVariable("name") String eventCategoryName) {
        List<EventCategory> eventCategories = eventCategoryService.findByEventCategoryName(eventCategoryName);
        return new ResponseEntity<>(eventCategories, HttpStatus.OK);
    }
}
