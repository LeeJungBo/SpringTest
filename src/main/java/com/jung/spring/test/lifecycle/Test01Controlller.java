package com.jung.spring.test.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lifecycle/test01")
public class Test01Controlller {

	@RequestMapping("/1")
	@ResponseBody
	public String StringResponse() {
		
		return "<h3><b>테스트 프로젝트 완성</b></h3><br>"//br이거 안써도 밑에꺼 h태그로 감싸면 알아서 줄바꿈됨
				+ "<b>해당 프로젝트를 통해서 문제 풀이를 진행 합니다.</b>";
		
	}
	
	
	@RequestMapping("/2")
	@ResponseBody
	public Map<String, Integer> mapResponse(){
		
		Map<String, Integer> subjectMap = new HashMap<>();
		
		subjectMap.put("국어", 80);
		subjectMap.put("수학", 90);
		subjectMap.put("영어", 85);
		
		return subjectMap;
	}
	
	
	
		
	
	
}
