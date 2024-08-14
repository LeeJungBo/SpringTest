package com.jung.spring.test.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jung.spring.test.database.domain.Store;

@Mapper
public interface StoreRepository {
	// 모든 테이블을 조회하기 위해서 Repository 에서
	
	public List<Store> selectStoreList();
	
	
	
	
	
	
	
}
