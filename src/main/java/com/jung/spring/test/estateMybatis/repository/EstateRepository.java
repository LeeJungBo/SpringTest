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
	
}
