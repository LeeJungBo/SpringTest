package com.jung.spring.test.weatherhistory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jung.spring.test.weatherhistory.domain.WeatherHistory;
import com.jung.spring.test.weatherhistory.repository.WeatherHistoryRepository;

@Service
public class WeatherHistoryService {

	@Autowired
	WeatherHistoryRepository weatherHistoryRepository;
	
	public List<WeatherHistory> getWeatherHistory() {
		List<WeatherHistory> weatherHistory = weatherHistoryRepository.selectWeatherHistory();
		return weatherHistory;
	}
	
	
	public int addByObjectParameter(WeatherHistory weatherHistory) {
		 int count = weatherHistoryRepository.insertByObjectParameter(weatherHistory);
		 return count;
	}
	
	
	
}
