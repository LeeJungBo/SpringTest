package com.jung.spring.test.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jung.spring.test.database.domain.Store;
import com.jung.spring.test.database.repository.StoreRepository;

@Service
public class StoreService {// 지금은 양이 적어 별 특별한 기능이 없지만 나중에 되면 많아짐 
						   // 그래서 StoreController랑 코드가 거의 똑같음(지금 당장만 그런거임)
		
		
		
		@Autowired
		private StoreRepository storeRepository;//원래 new StoreRepository();이거 해줄수 있지만 @Autowired가 있어 알아서 만들어줘서 관리해줌
	
	
		// 가게 정보 리스트 리턴 가능
		public List<Store> getUsedStoreList(){
				
			List<Store> storeList = storeRepository.selectStoreList();
			
			return storeList;
		}
	
}
