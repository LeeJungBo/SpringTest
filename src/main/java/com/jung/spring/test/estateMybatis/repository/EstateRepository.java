package com.jung.spring.test.estateMybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jung.spring.test.estateMybatis.domain.Estate;

@Mapper
public interface EstateRepository {

	// 한 행만 조회(따라서 List x)
	public Estate selectEstate(@Param("id") int id);
	
	
	public List<Estate> selectEstateRentPrice(@Param("rentPrice") int rentPrice);
	
	
	public List<Estate> selectEstateAreaOrPrice(@Param("area") int area, @Param("price") int price);
	
	
	public int insertEstateByObject(Estate estate); // insert는 사실 기능 수행만 하면 되어서 리턴타입을 따로 정해줄 필요가 없다 따라서 그냥 사용법을 int로 해서 수행된 행의 개수를 돌려받게끔

	
	public int insertEstateByObjectAndParamter(
			@Param("realtorId") int realtorId
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price
			, @Param("rentPrice") int rentPrice);
	
	
	public int updateEstateByObject(
			@Param("type") String type
			, @Param("price") int price
			, @Param("id") int id
			);
	
	public int deleteEstateByObject(
			@Param("id") int id);
	
}
