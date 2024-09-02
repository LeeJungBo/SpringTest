package com.jung.spring.test.recruit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jung.spring.test.recruit.domain.Incruit;

public interface IncruitRepository extends JpaRepository<Incruit, Integer> {

	// public Incruit findById(int id); 원래 포함되어있는건 쓸 필요가 없다
	
	//웹 back-end 개발자 이고 정규직인 공고

	public List<Incruit> findByPositionAndType(String position, String type);
	
	public List<Incruit> findByTypeOrSalaryGreaterThanEqual(String type, int salary);

	// WHERE `type`='계약직' ORDER BY `salary` DESC LIMIT 3
	public List<Incruit> findTop3ByTypeOrderBySalaryDesc(String type);

	// WHERE `region`= #{region} AND `salary` BETWEEN #{start} AND #{end} 
	public List<Incruit> findByRegionAndSalaryBetween(String region, int startSalary, int endSalary);
	
	//
	@Query(value="SELECT * FROM `recruit`" 
			+ " WHERE `deadline` > :deadline"
			+ " AND `salary` >= :salary"
			+ " AND `type` = :type"
			+ " ORDER BY `salary` DESC", nativeQuery=true)
	public List<Incruit> selectByNativeQuery(@Param("deadline") String deadline
											 , @Param("salary") int salary
											 , @Param("type") String type);
}
