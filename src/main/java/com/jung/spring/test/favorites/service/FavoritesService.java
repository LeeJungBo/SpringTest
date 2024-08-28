package com.jung.spring.test.favorites.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.jung.spring.test.favorites.domain.Favorites;
import com.jung.spring.test.favorites.repository.FavoritesRepository;

@Service
public class FavoritesService {

	@Autowired
	private FavoritesRepository favoritesRepository;
	
	public List<Favorites> getFavoritesList(){
		
		List<Favorites> favorites = favoritesRepository.selectFavoritesList();
		
		return favorites;
	}
	
	public int addFavoritesList(
			String name
			, String url) {
		int count = favoritesRepository.insertFavoritesList(name,url);
		
		return count;
		
	}
	
	public boolean isDuplicateUrl(String url) {
		int count = favoritesRepository.selectUrl(url);
		
		if(count == 0) {
			// 반복 안됨
			return false;
		}else {
			// 반복 됨
			return true;
		}
		
		// return count != 0; 이렇게만 적어도 됨 그냥 트루값만 돌려줘서 컨트롤러에서 "!" 쓰면됨
		
	}
	
	public int deleteData(int id) {
		
		int count = favoritesRepository.deleteByOfObject(id);
				
		return count;
	}
	
	
	
}
