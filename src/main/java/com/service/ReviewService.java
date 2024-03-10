package com.service;

import java.util.List;

import com.model.Review;

public interface ReviewService {
	public Review addReview(Review review);
	
	public void deleteReview(long reviewId);
	
	public List<Review> getAllReview();
	
	public Review updateReview(Review review);

}
