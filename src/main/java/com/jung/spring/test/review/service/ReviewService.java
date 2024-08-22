package com.jung.spring.test.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jung.spring.test.review.domain.Review;
import com.jung.spring.test.review.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	public List<Review> getReviewList() {
		
		 List<Review> reviewList = reviewRepository.selectReviewList();
		 
		 return reviewList;
	}
	
	
}
