package com.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookingId;
	@JsonFormat(pattern="yyyy/MM/dd")
	private Date bookingDate;
	private int bookingDays;
	
	@OneToOne(fetch = FetchType.EAGER)
	public Customer customer;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(long bookingId, Date bookingDate, int bookingDays, Customer customer) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.bookingDays = bookingDays;
		this.customer = customer;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getBookingDays() {
		return bookingDays;
	}

	public void setBookingDays(int bookingDays) {
		this.bookingDays = bookingDays;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", bookingDays=" + bookingDays
				+ ", customer=" + customer + "]";
	}
	
	

}
