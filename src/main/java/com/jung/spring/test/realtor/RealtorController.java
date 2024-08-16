package com.jung.spring.test.realtor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jung.spring.test.realtor.domain.Realtor;
import com.jung.spring.test.realtor.service.RealtorService;

@Controller
@RequestMapping("/realtor")
public class RealtorController {

	@Autowired
	private RealtorService realtorService;
	
	
	
	@PostMapping("/create")
	public String createRealtor
	(		
//			@RequestParam("office") String office
//			, @RequestParam("phoneNumber") String phoneNumber
//			, @RequestParam("address") String address
//			, @RequestParam("grade") String grade
			@ModelAttribute Realtor realtor // 이런 사용법이 있다 멤버변수하고만 매칭되면 얘가 알아서 객체 생성해주고 전달해줌
			, Model model){
		
//		Realtor realtor = new Realtor();
//		realtor.setOffice(office);
//		realtor.setPhoneNumber(phoneNumber);
//		realtor.setAddress(address);
//		realtor.setGrade(grade);
		
		realtorService.addRealtorByObject(realtor);
		
		model.addAttribute("result", realtor);
		return "mvc/realtorOutput";
		
	}
	
	
	
	@GetMapping("/input")
	public String realtorInput() {
		return "mvc/realtorInput";
	}
	
	
	
	
	
}
