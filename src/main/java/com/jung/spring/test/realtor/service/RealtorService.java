package com.jung.spring.test.realtor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jung.spring.test.realtor.domain.Realtor;
import com.jung.spring.test.realtor.repository.RealtorRepository;


@Service
public class RealtorService {

	@Autowired
	private RealtorRepository realtorRepository;
	
	
	
	public int addRealtorByObject(Realtor realtor) {
		int count = realtorRepository.insertRealtorByObject(realtor);
		return count;
	}
	
	
	
}
