package com.jung.spring.test.favorites.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jung.spring.test.favorites.domain.Favorites;

@Mapper
public interface FavoritesRepository {

	public List<Favorites> selectFavoritesList();
	
	
	public int insertFavoritesList(
			@Param("name") String name
			, @Param("url") String url);
	
	
	
}
