package com.model;

import java.util.List;

import jakarta.persistence.*;
@Entity
public class Organizer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long organizerId;
	private String organizerName;
	private String organizerPass;
	private String email;

	@OneToMany(fetch = FetchType.EAGER)
	public List<Event> event;

	public Organizer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Organizer(long organizerId, String organizerName, String organizerPass, String email, List<Event> event) {
		super();
		this.organizerId = organizerId;
		this.organizerName = organizerName;
		this.organizerPass = organizerPass;
		this.email = email;
		this.event = event;
	}

	public long getOrganizerId() {
		return organizerId;
	}

	public void setOrganizerId(long organizerId) {
		this.organizerId = organizerId;
	}

	public String getOrganizerName() {
		return organizerName;
	}

	public void setOrganizerName(String organizerName) {
		this.organizerName = organizerName;
	}

	public String getOrganizerPass() {
		return organizerPass;
	}

	public void setOrganizerPass(String organizerPass) {
		this.organizerPass = organizerPass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Event> getEvent() {
		return event;
	}

	public void setEvent(List<Event> event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Organizer [organizerId=" + organizerId + ", organizerName=" + organizerName + ", organizerPass="
				+ organizerPass + ", email=" + email + ", event=" + event + "]";
	}
	
	
}
