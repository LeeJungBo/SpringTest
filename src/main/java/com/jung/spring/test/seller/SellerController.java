package com.jung.spring.test.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jung.spring.test.seller.domain.Seller;
import com.jung.spring.test.seller.service.SellerService;

@Controller
@RequestMapping("/mvc/seller")
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	//데이터 저장과정을 진행할 페이지
	@PostMapping("/create")  // 이미지 주소가 엄청 길어서 길이를 제한하기 위해서
	// @ResponseBody redirect가 있기에 사라져야함
	public String createSeller(
			@RequestParam("nickname") String nickname
			,@RequestParam("temperature") double temperature
			,@RequestParam("profileImage") String profileImage) {
		int count = sellerService.addByObjectParameter(nickname,temperature, profileImage);
		
		// redirect : response에 특정 path(경로) 로 이동하라는 정보를 전달
		return "redirect:/mvc/seller/output";
	}
	
	
	@GetMapping("/input") //앞으로 우리가 무조건 브라우저를 띄우기 위해선 컨트롤러에 있는 mapping을 통해서이다. 즉, 이 주소를 띄우고 화면을 저기 SellerInput.html을 띄워야하는것이다.
	public String sellerInput(){
		return "/mvc/SellerInput";
		
	}
	
	
	
	
	@GetMapping("/output") // 아하 @RequestParam(value = "id", required=false 여기서 required값을 false로 해줘야하는구나 (알아갈것 Integer은 null값을 가질수 있음))
	public String lastSellerOutput(@RequestParam(value = "id", required=false) Integer id, Model model) { // RequestParam도 숨겨져 있는게 있다.(value = "id", required=true(필수라는거))숨겨져 있는거
//		Seller lastSeller = sellerService.getLastSeller();					 // true를 false도 나올수 있게 한다. null을 저장할수 있는 wrapper타입으로 바꿔준다
		
		// id가 전달이 안되면 최근 판매자 조회
		// id가 전달이 되면 매치된 판매자 조회
		Seller seller = null;
		if(id == null) {	 
			seller = sellerService.getLastSeller();
		}else{
			seller = sellerService.getSeller(id);
		}
		
		model.addAttribute("result",seller);
		model.addAttribute("title", "판매자 추가");
		
		return "mvc/SellerOutput";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
