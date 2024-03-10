package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Booking;
import com.service.BookingServiceImp;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingServiceImp bookingService;

    @PostMapping("/addbooking")
    public Booking addEventBooking(@RequestBody Booking be) {
        return bookingService.addEventBooking(be);
    }

    @DeleteMapping("/deletbooking/{bookingId}")
    public void cancelEvent(@PathVariable long bookingId) {
        bookingService.cancelEvent(bookingId);
    }

    @GetMapping("/getallbooking")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBooking();
    }

    @GetMapping("/getbooking/{bookingId}")
    public Booking getOneUser(@PathVariable long bookingId) {
        return bookingService.getOneUser(bookingId);
    }

    @PutMapping("/updatebooking/{bookingId}")
    public Booking updateUser(@PathVariable long bookingId, @RequestBody Booking be) {
        be.setBookingId(bookingId); // Ensure bookingId consistency
        return bookingService.updateUser(be);
    }
}

