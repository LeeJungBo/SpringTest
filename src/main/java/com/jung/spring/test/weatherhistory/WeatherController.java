package com.jung.spring.test.weatherhistory;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jung.spring.test.weatherhistory.domain.WeatherHistory;
import com.jung.spring.test.weatherhistory.service.WeatherHistoryService;

@Controller
@RequestMapping("/weatherHistory/test04")
public class WeatherController {

	@Autowired
	WeatherHistoryService weatherHistoryService;
	
	
	@GetMapping("/output")
	public String test04(Model model) {
		
		List<WeatherHistory> weatherHistory = weatherHistoryService.getWeatherHistory();
		
		model.addAttribute("weatherHistory", weatherHistory);
		
		return "thymeleaf/test04";
	}
	
	
	@GetMapping("/input")
	public String test04Input() {
		return "thymeleaf/test04input";
	}
	
	
	
	@PostMapping("/create")
	public String createWeatherHistory(
			@RequestParam("date") LocalDate date
			, @RequestParam("weather") String weather
			, @RequestParam("temperatures") double temperatures
			, @RequestParam("precipitation") double precipitation
			, @RequestParam("microDust") String microDust
			, @RequestParam("windSpeed") double windSpeed
			, Model model) {
		
		WeatherHistory weatherHistory = new WeatherHistory();
		weatherHistory.setDate(date);
		weatherHistory.setWeather(weather);
		weatherHistory.setTemperatures(temperatures);
		weatherHistory.setPrecipitation(precipitation);
		weatherHistory.setMicroDust(microDust);
		weatherHistory.setWindSpeed(windSpeed);
		
		 weatherHistoryService.addByObjectParameter(weatherHistory);
		 
		 model.addAttribute("weatherHistory", weatherHistory);
		
		return "redirect:/weatherHistory/test04/output";
	}
	
	
	
	
	
	
	
	
	
	
}
