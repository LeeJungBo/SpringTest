package com.jung.spring.test.estateMybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jung.spring.test.estateMybatis.domain.Estate;
import com.jung.spring.test.estateMybatis.repository.EstateRepository;

@Service
public class EstateService {
	
	@Autowired
	private EstateRepository estateRepository;
	
	public Estate getEstate(int id){
		Estate estate = estateRepository.selectEstate(id);
		return estate;
	}
	
	public List<Estate> getEstateRentPrice(int rentPrice) {
		List<Estate> estateList = estateRepository.selectEstateRentPrice(rentPrice);
		return estateList;
	}
	
	public List<Estate> getEstateAreaOrPrice(int area, int price){
		List<Estate> estateAreaOrPrice = estateRepository.selectEstateAreaOrPrice(area, price);
		return estateAreaOrPrice;
	}
	
	
	
}
