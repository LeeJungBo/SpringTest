package com.jung.spring.test.seller.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jung.spring.test.seller.domain.Seller;

@Mapper
public interface SellerRepository {

	
	
	
	public int insertByObjectParameter(@Param("nickname") String nickname,@Param("temperature") double temperature, @Param("profileImage") String profileImage);
	
	
	
	public Seller selectLastSeller();
	
	
	public Seller selectSeller(@Param("id") Integer id);
	
	
	
	
}
