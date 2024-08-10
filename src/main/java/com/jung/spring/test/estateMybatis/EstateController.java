package com.jung.spring.test.estateMybatis;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jung.spring.test.estateMybatis.domain.Estate;
import com.jung.spring.test.estateMybatis.service.EstateService;

@RequestMapping("/mybatis/real-estate")
@Controller //RequestMapping("/mybatis/real-estate") 여기서 공통된 요소는 여기다가 넣어주는게 낫다
public class EstateController {
	
	@Autowired
	private EstateService estateService; //원래 new ~(); 이렇게 해줘야하지만 @Autowired 이게 들어가서 안해줘도되는거
								 // springs에서 알아서 객체생성 해주고 관리해주니
	
	@ResponseBody
	@RequestMapping("/1")
	public Estate estate(@RequestParam("id") int id) {
		Estate estate = estateService.getEstate(id);
		return estate;
	}
	
	@ResponseBody // template might not exist or might not be accessible by any of the configured Template Resolvers 이런 에러떠서 봤더니 이게 안되어있었음
	@RequestMapping("/2") // 보여주는것이 2개의 데이터이기 때문에 List를 붙여줘야함
	public List<Estate> estateRentprice(@RequestParam("rentPrice") int rentPrice) {
		List<Estate> estateList = estateService.getEstateRentPrice(rentPrice);
		return estateList;
	}
	
	
	@ResponseBody
	@RequestMapping("/3")
	public List<Estate> estateAreaOrPrice(@RequestParam("area") int area, @RequestParam("price") int price){
		List<Estate> estateAreaOrPrice = estateService.getEstateAreaOrPrice(area, price);
		return estateAreaOrPrice;
	}
	
	@RequestMapping("/4")
	@ResponseBody
	public String createEstate() {
		Estate estate = new Estate();
		estate.setRealtorId(3);
		estate.setAddress("푸르지용 리버 303동 1104호");
		estate.setArea(89);
		estate.setType("매매");
		estate.setPrice(100000);
		
		int count = estateService.addEstateByObject(estate);
		
		return "입력 개수 : " + count; 
		
		
//		private int id;
//		private int realtorId;
//		private String address;
//		private int area;
//		private String type;
//		private int price;
//		private int rentPrice;
//		private LocalDateTime createdAt;
//		private LocalDateTime updatedAt;
	}
			
	@ResponseBody
	@RequestMapping("/5")
	public String createEstateAndParameter(@RequestParam("realtorId") int realtorId) {
		
		int count = estateService.addEstateByObjectAndParameter(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		return "입력 개수 : " + count;	
	}
	
	@ResponseBody
	@RequestMapping("/6")
	public String updateEstate() {
		int count = estateService.getUpdateEstate("전세", 70000, 22);
		return "수정 성공 : " + count;
				
	}
	
	@ResponseBody
	@RequestMapping("/7")
	public String deleteEstate(@RequestParam("id") int id) {
		int count = estateService.getDeleteEstate(id);
		return "삭제 성공 : " + count;
	}
	
	
	
}
