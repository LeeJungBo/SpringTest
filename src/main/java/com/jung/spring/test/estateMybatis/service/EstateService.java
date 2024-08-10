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
	
	// insert 쿼리는 int로 고정되어있음
	public int addEstateByObject(Estate estate) {
		int count = estateRepository.insertEstateByObject(estate);
		return count;
	}
	
	public int addEstateByObjectAndParameter(int realtorId
											, String address
											, int area
											, String type
											, int price
											, int rentPrice) {
		int count = estateRepository.insertEstateByObjectAndParamter(realtorId, address, area, type, price, rentPrice);
		return count;
		
	}
	
	public int getUpdateEstate(String type, int price, int id) {
		int count = estateRepository.updateEstateByObject(type, price, id);
		return count;
	}
	
	public int getDeleteEstate(int id) {
		int count = estateRepository.deleteEstateByObject(id);
		return count;
	}
	
}
