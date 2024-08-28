package com.jung.spring.test.newReview;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jung.spring.test.newReview.domain.NewReview;
import com.jung.spring.test.newReview.service.NewReviewService;

@RequestMapping("/newReview")
@Controller
public class NewReviewController {

	@Autowired
	private NewReviewService newReviewService;
	
	@GetMapping("/list")
	public String newReview(Model model) {
	
		List<NewReview> newReviewList = newReviewService.getNewReview();
	
		model.addAttribute("newReviewList", newReviewList);
		
		return "thymeleaf/store/newReviewList";
	
	}
	
	
	
}
