package com.jung.spring.test.newReview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jung.spring.test.newReview.domain.NewReview;
import com.jung.spring.test.newReview.repository.NewReviewRepository;

@Service
public class NewReviewService {

	@Autowired
	private NewReviewRepository newReviewRepository;
	
	public List<NewReview> getNewReview(){
		
		List<NewReview> newReviewList = newReviewRepository.selectNewReview();
	
		return newReviewList;
	}
	
}
