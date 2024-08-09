package com.jung.spring.test.estateMybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jung.spring.test.estateMybatis.domain.Estate;
import com.jung.spring.test.estateMybatis.service.EstateService;

@Controller
public class EstateController {
	
	@Autowired
	private EstateService estateService; //원래 new ~(); 이렇게 해줘야하지만 @Autowired 이게 들어가서 안해줘도되는거
								 // springs에서 알아서 객체생성 해주고 관리해주니
	
	@ResponseBody
	@RequestMapping("/mybatis/real-estate/1")
	public Estate estate(@RequestParam("id") int id) {
		Estate estate = estateService.getEstate(id);
		return estate;
	}
	
	@ResponseBody // template might not exist or might not be accessible by any of the configured Template Resolvers 이런 에러떠서 봤더니 이게 안되어있었음
	@RequestMapping("/mybatis/real-estate/2") // 보여주는것이 2개의 데이터이기 때문에 List를 붙여줘야함
	public List<Estate> estateRentprice(@RequestParam("rentPrice") int rentPrice) {
		List<Estate> estateList = estateService.getEstateRentPrice(rentPrice);
		return estateList;
	}
	
	
	@ResponseBody
	@RequestMapping("/mybatis/real-estate/3")
	public List<Estate> estateAreaOrPrice(@RequestParam("area") int area, @RequestParam("price") int price){
		List<Estate> estateAreaOrPrice = estateService.getEstateAreaOrPrice(area, price);
		return estateAreaOrPrice;
	}
	
	
	
	
}
