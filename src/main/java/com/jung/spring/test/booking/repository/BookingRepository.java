package com.jung.spring.test.booking.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jung.spring.test.booking.domain.Booking;

@Mapper
public interface BookingRepository {

	
	public List<Booking> selectBooking();
	
	public int deleteByObject(@Param("id") int id);
	
	public int createByObject(Booking booking);
	
	public Booking selectLookUpBooking(@Param("name") String name, @Param("phoneNumber") String phoneNumber);
	
}
