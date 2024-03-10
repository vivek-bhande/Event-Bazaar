package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ReviewRepository;
import com.model.Review;

@Service
public class ReviewServiceImp implements ReviewService {

	@Autowired
	ReviewRepository reviewRepo;
	
	@Override
	public Review addReview(Review review) {
		return reviewRepo.save(review);
	}

	@Override
	public void deleteReview(long reviewId) {
		reviewRepo.deleteById(reviewId);

	}

	@Override
	public List<Review> getAllReview() {
		return reviewRepo.findAll();
	}

	@Override
	public Review updateReview(Review review) {
		Review re=reviewRepo.findById(review.getReviewId()).orElse(null);
		re.setDescription(review.getDescription());
		return reviewRepo.save(re);
	}

}
