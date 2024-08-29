package com.jung.spring.test.company.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jung.spring.test.company.domain.Company;
import com.jung.spring.test.company.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public Company addComany(String name, String business, String scale, int headcount, String region) {
		
		Company company = Company.builder()
		.name(name)
		.business(business)
		.scale(scale)
		.headcount(headcount)
		.region(region)
		.build();
		
		Company result = companyRepository.save(company);
		return result;
	}
	
	public Company updateCompany(int id, String scale, int headcount) {
		
		Optional<Company> optionalCompany = companyRepository.findById(id);
		
		Company company = optionalCompany.orElse(null);
		
		company = company.toBuilder()
						 .scale(scale)
						 .headcount(headcount)
						 .build();
		
		Company result = companyRepository.save(company);
		return result;
	}
	
	public void deleteCompany(int id) {
		Optional<Company> optionalCompany = companyRepository.findById(id);
//		Company company = optionalCompany.orElse(null);
//		
//		if(company != null) { //null이 아닐때만 사용
//			companyRepository.delete(company);
//		}
//
//		isPresent(present 현재의) 즉, '현재 있냐 주어가	'란 뜻으로 즉 변수값이 현재 null이 아닌 값을 갖고있느냐란 뜻으로 해석(즉, 존재할때만 작용
//		if(optionalCompany.isPresent()) { // Optional 객체가 값을 가지고 있다면 true, 값이 없다면 false 리턴
//			companyRepository.delete(optionalCompany.get());
//		}
		
		
		// null이 아닐때 수행할 기능을 등록
		// c : optionalCompany 객체에 포함된 실제 객체
		//  ifPresent()는 Optional 객체가 값을 가지고 있으면 실행 값이 없으면 넘어감 (Void 타입)
		optionalCompany.ifPresent(c -> companyRepository.delete(c));
		
	}
	
	
	
	
	

}
