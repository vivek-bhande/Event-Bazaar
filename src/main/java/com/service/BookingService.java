package com.service;
import java.util.List;

import com.model.Booking;

public interface BookingService {

	public Booking addEventBooking(Booking be);
	
	public void cancelEvent(long bookingId);
	
	public List<Booking> getAllBooking();
	
	public Booking getOneUser(long bookingId);
	
	public Booking updateUser(Booking be);
}
