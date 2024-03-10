package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BookingRepository;
import com.model.Booking;

@Service
public class BookingServiceImp implements BookingService {
	
	@Autowired
	BookingRepository bookingRepo;

	@Override
	public Booking addEventBooking(Booking be) {
		return bookingRepo.save(be);
	}

	@Override
	public void cancelEvent(long bookingId) {
		bookingRepo.deleteById(bookingId);
	}

	@Override
	public List<Booking> getAllBooking() {
		return bookingRepo.findAll();
	}

	@Override
	public Booking getOneUser(long bookingId) {
		return bookingRepo.findById(bookingId).orElse(null);
	}

	@Override
	public Booking updateUser(Booking be) {
		Booking bookeve=bookingRepo.findById(be.getBookingId()).orElse(null);
		return bookingRepo.save(be);
	}

}
