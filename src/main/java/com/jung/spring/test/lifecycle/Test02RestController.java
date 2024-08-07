package com.jung.spring.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // ResponseBody + Controller
@RequestMapping("/lifecycle/test02")
public class Test02RestController {

	
	@RequestMapping("/1")
	public List<Map<String, Object>> movieDataList(){
		
		List<Map<String, Object>> movieList = new ArrayList<>();
		
		
			Map<String, Object> movieMap = new HashMap<>();//객체생성 수는 여러개가 되어야한다(반복문을 넣던지) 맵집합이 5개이니 그 집합수만큼
			Map<String, Object> movieMap1 = new HashMap<>();
			Map<String, Object> movieMap2 = new HashMap<>();
			Map<String, Object> movieMap3 = new HashMap<>();
			Map<String, Object> movieMap4 = new HashMap<>();
			
			//movieMap = new HashMap<>();
			movieMap.put("rate", 15);
			movieMap.put("director", "봉준호");
			movieMap.put("time", 131);
			movieMap.put("title", "기생충");
			//movieList.add(movieMap);
			
			//movieMap = new HashMap<>(); 누누히 강조하지만 변수는 중요치 않음 객체가 중요 / 즉 객체만 만들어준다면 변수는 같은 이름이어도 다른 값을 가지게 된다는거
			movieMap1.put("rate", 0);
			movieMap1.put("director", "로베르토 베니니");
			movieMap1.put("time", 116);
			movieMap1.put("title", "인생은 아름다워");
			//movieList.add(movieMap); 이것처럼 변수이름이 중요한것이 아니다 변수이름이 같더라도 전혀 다른 값이고 객체가 중요한것 
			//즉 객체만 달리 써주면 변수는 그냥 가르키는 지표에 불과 따라서 이렇게 변수이름을 똑같이 써도 된다
			
			movieMap2.put("rate", 12);
			movieMap2.put("director", "크리스토퍼 놀란");
			movieMap2.put("time", 147);
			movieMap2.put("title", "인셉션");
			
			movieMap3.put("rate", 19);
			movieMap3.put("director", "윤종빈");
			movieMap3.put("time", 133);
			movieMap3.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
			
			movieMap4.put("rate", 15);
			movieMap4.put("director", "프란시스 로렌스");
			movieMap4.put("time", 137);
			movieMap4.put("title", "헝거게임");
		
			
			movieList.add(movieMap);
			movieList.add(movieMap1);
			movieList.add(movieMap2);
			movieList.add(movieMap3);
			movieList.add(movieMap4);
		
			return movieList;
		
	}
	
	
	@RequestMapping("/2")
	public List<NoticBoard> objectResponse() {// <NoticBoard>는 내가 직접 만들어준 클래스를 타입으로 쓰는것으로써 class를 보면 알겠지만 map형태로 되어있음
											  // 또한 기본생성자를 통해 반드시 들어가야할 성질 멤버변수가 필요하고 거기에 대응하는 값이 결국 Value가 되는것
		List <NoticBoard> boardList = new ArrayList<>();
		
		
		NoticBoard board = new NoticBoard("안녕하세요 가입인사 드립니다.", "hagulu", "안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다.");
		boardList.add(board);
		boardList.add(new NoticBoard("헐 대박", "bada", "오늘 목요일이 었어...금요일인줄"));
		boardList.add(new NoticBoard("오늘 데이트 한 이야기 해드릴게요.", "dulumary", "....."));
		
		
		return boardList;
		
		
		
		
	}
	
	
	
	@RequestMapping("/3")
	public ResponseEntity<NoticBoard> boardError(){
		
		NoticBoard board = new NoticBoard("안녕하세요 가입인사 드립니다.", "hagulu", "안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다.");
		
		return new ResponseEntity<>(board, HttpStatus.INTERNAL_SERVER_ERROR);//이걸 변수로 만들어서 리턴해줘도 된다
		//브라우저 검사-네트워크 들어가면 status 고의로 500을 뜨게 해서 에러를 뜨게해서 단지 출력내용만을 내가 원하는데로 하는거
		// 이거 자체가 객체 -> new ResponseEntity<>()
	}
	
	
	
	
	
	
	
	
	
}
