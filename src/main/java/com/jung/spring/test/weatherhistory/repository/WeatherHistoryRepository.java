package com.jung.spring.test.weatherhistory.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jung.spring.test.weatherhistory.domain.WeatherHistory;

@Mapper
public interface WeatherHistoryRepository {


	
	public List<WeatherHistory> selectWeatherHistory();
	
	public int insertByObjectParameter(WeatherHistory weatherHistory);
	
	
}
