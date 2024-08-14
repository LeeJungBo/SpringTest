package com.jung.spring.test.seller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jung.spring.test.seller.domain.Seller;
import com.jung.spring.test.seller.repository.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	
	// 닉네임, 매너온도, 프로필 이미지 경로 전달 받고 판매자 정보 저장
	
	
	
	public int addByObjectParameter(String nickname,double temperature, String profileImage) {
		 int count = sellerRepository.insertByObjectParameter(nickname,temperature, profileImage);
		 return count; // 잘 저장되었는데 보기위해 확인차 만들어주자
	}
	
	
	public Seller getLastSeller() {
		Seller seller = sellerRepository.selectLastSeller();
		
		return seller;
	}
	
	public Seller getSeller(Integer id) {
		Seller seller = sellerRepository.selectSeller(id);
		
		return seller;
	}
	
	
	
	
	
}
