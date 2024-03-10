package com.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long reviewId;
	private  String description;
	
	@ManyToMany(fetch = FetchType.EAGER)
	public List<Customer> customer;

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(long reviewId, String description, List<Customer> customer) {
		super();
		this.reviewId = reviewId;
		this.description = description;
		this.customer = customer;
	}

	public long getReviewId() {
		return reviewId;
	}

	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", description=" + description + ", customer=" + customer + "]";
	}
	
	

}
