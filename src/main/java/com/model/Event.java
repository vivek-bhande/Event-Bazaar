package com.model;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long eventId;
	private String eventName;
	private int peopleCapacity;
	private String location;
	private int price;
	private String description;
//	@Lob
//	private byte[] image;
	
	@OneToOne(fetch = FetchType.EAGER)
	public Booking booking;
	
	@ManyToMany(fetch = FetchType.EAGER)
	public List<Review> review;

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(long eventId, String eventName, int peopleCapacity, String location, int price, String description,
			Booking booking, List<Review> review) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.peopleCapacity = peopleCapacity;
		this.location = location;
		this.price = price;
		this.description = description;
		this.booking = booking;
		this.review = review;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getPeopleCapacity() {
		return peopleCapacity;
	}

	public void setPeopleCapacity(int peopleCapacity) {
		this.peopleCapacity = peopleCapacity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", peopleCapacity=" + peopleCapacity
				+ ", location=" + location + ", price=" + price + ", description=" + description + ", booking="
				+ booking + ", review=" + review + "]";
	}
	
}
