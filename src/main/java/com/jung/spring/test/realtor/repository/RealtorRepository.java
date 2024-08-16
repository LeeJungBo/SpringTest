package com.jung.spring.test.realtor.repository;

import org.apache.ibatis.annotations.Mapper;

import com.jung.spring.test.realtor.domain.Realtor;

@Mapper
public interface RealtorRepository {

	public int insertRealtorByObject(Realtor realtor);
	
}
