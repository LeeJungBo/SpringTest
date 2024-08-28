package com.jung.spring.test.newReview.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jung.spring.test.newReview.domain.NewReview;

@Mapper
public interface NewReviewRepository {

	public List<NewReview> selectNewReview();
	
	
}
