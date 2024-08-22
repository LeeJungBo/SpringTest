package com.jung.spring.test.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jung.spring.test.review.domain.Review;
import com.jung.spring.test.review.service.ReviewService;

@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("/review/list")
	public String ReviewList() {
		
		List<Review> reviewList = reviewService.getReviewList();
		
		return "";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
