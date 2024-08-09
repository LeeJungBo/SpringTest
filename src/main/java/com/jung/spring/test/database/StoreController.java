package com.jung.spring.test.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jung.spring.test.database.domain.Store;
import com.jung.spring.test.database.service.StoreService;

@Controller
public class StoreController {

	//request와 response역할만 해야됨
	
	@Autowired						
	private StoreService storeService;
	// Autowired
	// 객체를 spring에서 자동으로 생성해준다
	// @ Controller @Service @Repository를 만들면 자동생성
	// 해당 어노테이션을 통해서 Spring Bean으로 등록
	// Spring에서 객체 관리를 효율적으로 하기위해 사용
	// DI, IoC, POJO
	
	@RequestMapping("/db/store/list")
	@ResponseBody
	public List<Store> storeList() {
		
		List<Store> storeList = storeService.getUsedStoreList();
		
		return storeList;
		
	}
	
	
	
	
}
