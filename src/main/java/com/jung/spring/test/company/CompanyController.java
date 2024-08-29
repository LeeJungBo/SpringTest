package com.jung.spring.test.company;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jung.spring.test.company.domain.Company;
import com.jung.spring.test.company.service.CompanyService;

@Controller
@RequestMapping("/jpa/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/create")
	@ResponseBody
	public List<Company> createCompany() {
		
		List<Company> companyList = new ArrayList<>();
		
		
		Company company = companyService.addComany("넥손", "컨텐츠 게임", "대기업", 3585, "성남시 분당구");
		companyList.add(company);
		
		company = companyService.addComany("버블팡", "여신 금융업", "대기업", 6834, "성남시 태평동");
		companyList.add(company);
		
		return companyList;
		
	}
	
	@GetMapping("/update")
	@ResponseBody
	public Company updateCompany() {
		Company company = companyService.updateCompany(16, "중소기업", 34);
		return company;
	}
	
	
	@GetMapping("/delete")
	@ResponseBody
	public String deleteCompany() {
		companyService.deleteCompany(16);
		return "수행 완료";
	}
	
	
}
