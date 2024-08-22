package com.jung.spring.test.weatherhistory;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
	private WeatherHistoryService weatherHistoryService;
	
	
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
			@RequestParam("date") @DateTimeFormat(pattern="yyyy년 MM월 dd일") LocalDate date // 얘의 타입을 LocalDate 이걸로 해주면 스프링에서 알아서 날짜타입으로 인식해줘서 저장해줌(그러나 얘가 '-월 -일' 이렇게 표현되면 에러가 뜸)
			, @RequestParam("weather") String weather         // ("-월 -일" 은 LocalDate("2024-04-21" 이런식의 형태로만 관리)가 관리하는 형태가 아님 (위에 @어노테이션을 써줘서 스프링에게 한글인 '월 -일'이 날짜라는것을 알려줘야한다)         	
			, @RequestParam("temperatures") double temperatures // ---> 얘같은 경우에도 처음에 문자열로 저장되었다가 알아서 double 타입으로 스프링이 알아서 바꿔줘서 해줌
			, @RequestParam("precipitation") double precipitation // ("precipitation")이거 빼도 된다 자꾸 초록색 뜨는거  약간은 찝찝하니 (spring이 계속 진화하는거)
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
