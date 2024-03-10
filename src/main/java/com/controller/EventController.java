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

import com.model.Event;
import com.service.EventService;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/addEvent")
    public ResponseEntity<Event> addEvent(@RequestBody Event e) {
        Event addedEvent = eventService.addEvent(e);
        return new ResponseEntity<>(addedEvent, HttpStatus.CREATED);
    }

    @DeleteMapping("/deletevent/{eventId}")
    public ResponseEntity<Void> cancelEvent(@PathVariable long eventId) {
        eventService.cancelEvent(eventId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getallevent")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvent();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @PutMapping("/updateevent/{eventId}")
    public ResponseEntity<Event> updateEvent(@PathVariable long eventId, @RequestBody Event e) {
        e.setEventId(eventId);
        Event updatedEvent = eventService.updateEvent(e);
        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }

    @GetMapping("getevent/{eventId}")
    public ResponseEntity<Event> getOneEvent(@PathVariable long eventId) {
        Event event = eventService.getOneEvent(eventId);
        if (event != null) {
            return new ResponseEntity<>(event, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/geteventbyname/name/{eventName}")
    public ResponseEntity<List<Event>> findByEventName(@PathVariable String eventName) {
        List<Event> events = eventService.findByEventName(eventName);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }
}
