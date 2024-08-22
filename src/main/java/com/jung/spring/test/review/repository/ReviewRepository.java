package com.jung.spring.test.review.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jung.spring.test.review.domain.Review;

@Mapper
public interface ReviewRepository {

	
	public List<Review> selectReviewList();
	
	
	
	
}
