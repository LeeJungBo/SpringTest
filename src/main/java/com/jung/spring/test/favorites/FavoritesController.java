package com.jung.spring.test.favorites;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jung.spring.test.favorites.domain.Favorites;
import com.jung.spring.test.favorites.service.FavoritesService;

@Controller
@RequestMapping("/ajax")
public class FavoritesController {

	@Autowired
	private FavoritesService favoritesService;
	
	@ResponseBody 
	@PostMapping("/create") // 서버오류 500 서버는 여기 html이 아니라 서버 여기 문제고 여기서 나는 jason을 담을라고 하는데 왜 얘는 자꾸 html을 담을라고 하고 있냐
	// ResponseBody로 해줘야 제이슨을 문자열변환하여로써 전달하게 되어 Ajax로 보내게 된다 / 만약 responseBody를 안붙히게 되면 그대로 html형태나 redirext가 있으면 redirect가 된곳의 형태를 그대로 보내게 된다
	// 즉 ResponseBody를 안붙히게 되면 templates에 있는 favoritesInput의 html형태가 그대로 스크립트에 있는 ajax로 전달되게 된다. 그렇게 되면 ajax는 아무 기능을 할수 없게 된다.
	public Map<String, String> createFavorites(
			@RequestParam("name") String name
			, @RequestParam("url") String url) {
		
		int count = favoritesService.addFavoritesList(name, url);
		
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	
	
	
	
	@GetMapping("/input")
	public String favoritesInput() {
		
		return "ajax/favorites/favoritesInput";
	}
	
	
	
	
	@GetMapping("/list") // 파라미터가 없기 때문에 Get이 맞고
	public String favoritesList(Model model) {
		
		List<Favorites> favorites= favoritesService.getFavoritesList();
		
		model.addAttribute("favoritesList", favorites);
		
		return "ajax/favorites/favoritesList";
	}
	
	
	
	
	
	
}
