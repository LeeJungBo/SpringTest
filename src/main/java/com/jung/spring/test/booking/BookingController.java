package com.jung.spring.test.booking;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jung.spring.test.booking.domain.Booking;
import com.jung.spring.test.booking.service.BookingService;

@Controller
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	
	@GetMapping("/list")
	public String BookList(Model model) {
		
		List<Booking> bookingList= bookingService.getBooking();
		
		model.addAttribute("bookingList", bookingList);
		
		return "booking/bookingList";
		
		
	}
	
	@ResponseBody
	@GetMapping("/delete-booking")
	public Map<String, String> deleteBookingList(@RequestParam("id") int id){
		
		int count = bookingService.deleteBookingList(id);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	
	@GetMapping("/input-booking")
	public String bookingInput() {
		
		return "booking/bookingInput";
	}
	
	
	
	@PostMapping("/create")
	@ResponseBody
	public Map<String, String> createBookingList(
			@RequestParam("name") String name
			, @RequestParam("date") @DateTimeFormat(pattern="yy-mm-dd") LocalDate date // 와 계속 여기서 헤매다가 LocalDateTime을 LocalDate로 바꾸니깐 되네 이것도 차이가 있구나 (그치 내가 입력한건 날짜만 있었던거)
			, @RequestParam("day") int day											   // 시간은 없었다 즉, 'Time'이 들어가면 안되는거
			, @RequestParam("headCount") int headCount
			, @RequestParam("phoneNumber") String phoneNumber){
		
		Booking booking = new Booking();
		booking.setName(name);
		booking.setHeadCount(headCount);
		booking.setDay(day);
		booking.setDate(date);
		booking.setPhoneNumber(phoneNumber);
		booking.setState("대기중"); // 이렇게 "대기중"과 같이 고정된값은 이렇게 객체로 넣어줄거면 이렇게 쓰고 아니면 repository메소드나 mapper에 넣어주는것이 좋다
		
		int count = bookingService.createBookingList(booking);
		
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
		
	}
	
	@GetMapping("/lookUp-booking")
	public String lookUp() {
		
		return "booking/lookUpBooking";
		
	}
	
	@ResponseBody
	@PostMapping("/lookUp")
	public Map<String, Object> lookUpBookingList(
			@RequestParam("name") String name //?name=~~~~~&phoneNumber=~~~ 이렇게 직접 주소창에 치고 한번 점검해주는것도 가능하다.
			, @RequestParam("phoneNumber") String phoneNumber) {
	
		
		
		Map<String, Object> resultMap = new HashMap<>(); 
		
		Booking booking  = bookingService.getLookUpBooking(name, phoneNumber);
		
		if(booking != null) {
			
			//{"result" : "success", "booking":booking (booking)자체가 여기로 들어가야하는데 "id":9, "name":장나라 ~~~~ 이런식으로 들어가게 }
			resultMap.put("result", "success");
			resultMap.put("booking", booking); //이런 형태가 더 명확한 형태다 // 이렇게 되면 ajax에다가 booking을 한번 더써줘야함 .ex) data.booking.name
		} else {
			resultMap.put("result", "fail");
		}
		
		// {"name":"김인규", "day":4, ......}
		
		// {"result" : "success"}
		return resultMap; // 이걸 문자열로 바꾸어서 요청하는것이다.
		
	}	
		
//		if(booking != null) {
//			return booking;
//		}else {
//			return null;
//		}
		
	
	
	
//	@ResponseBody  
//	@PostMapping("/lookUp")
//	public Map<String, Object> lookUpBookingList( // ------> 만약 cotain으로 포함되어 있지 않다면으로 한다면 
//			@RequestParam("name") String name
//			, @RequestParam("phoneNumber") String phoneNumber) {
//		
//		Map<String, Object> booking  = bookingService.getLookUpBooking(name, phoneNumber);
//		
//		if(booking.get("name").equals(name) && booking.get("phoneNumber").equals(phoneNumber)) {
//			return booking;
//		}else{
//			return null;
//		}
//		
//	
//	}
	
	
}
	
	
