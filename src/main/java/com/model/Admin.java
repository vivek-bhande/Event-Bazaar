package com.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Admin {
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String password;
	private String email;
	
	 @OneToMany(fetch = FetchType.EAGER)
	 public List<Organizer> organizer;
	 
	 @OneToMany(fetch = FetchType.EAGER)
	 public List<Customer> customer;
	 
	 @OneToMany(fetch = FetchType.EAGER)
	 public List<EventCategory> eventcategory ;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(long id, String name, String password, String email, List<Organizer> organizer,
			List<Customer> customer, List<EventCategory> eventcategory) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.organizer = organizer;
		this.customer = customer;
		this.eventcategory = eventcategory;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Organizer> getOrganizer() {
		return organizer;
	}

	public void setOrganizer(List<Organizer> organizer) {
		this.organizer = organizer;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public List<EventCategory> getEventcategory() {
		return eventcategory;
	}

	public void setEventcategory(List<EventCategory> eventcategory) {
		this.eventcategory = eventcategory;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", organizer="
				+ organizer + ", customer=" + customer + ", eventcategory=" + eventcategory + "]";
	}

	
	 
	 
}
