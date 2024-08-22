package com.jung.spring.test.favorites.service;

import java.util.List;

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
	
	
	
	
	
}
