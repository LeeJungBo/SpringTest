package com.jung.spring.test.recruit;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jung.spring.test.recruit.domain.Incruit;
import com.jung.spring.test.recruit.repository.IncruitRepository;

@RestController // ResponseBody + RequestMapping
@RequestMapping("/jpa/incruit")
public class IncruitController {

	@Autowired
	private IncruitRepository incruitRepository;
	
	@GetMapping("/find-one")
	public Incruit findIncruit() {
		
		Optional<Incruit> optionalIncruit = incruitRepository.findById(8);
		Incruit incruit = optionalIncruit.orElse(null);
		
		
		return incruit;
	}
	
	@GetMapping("/findParameter-one")
	public Incruit findIncruitParameter(@RequestParam("id") int id) {
		
		Optional<Incruit> optionalIncruit = incruitRepository.findById(id);
		Incruit incruit = optionalIncruit.orElse(null);
		
		return incruit;
		
	}
	
	@GetMapping("/find")
	public List<Incruit> findIncruitList(){
		
		List<Incruit> incruitList = null;
		
//		incruitList = incruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
		
		
//		incruitList = incruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
	

//      incruitList = incruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
		

		incruitList = incruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8000);
		
		incruitList = incruitRepository.selectByNativeQuery("2026-04-10 00:00:00", 8100, "정규직");
		
		return incruitList;
		
		
		
		
		
	}
	
	
	
}
