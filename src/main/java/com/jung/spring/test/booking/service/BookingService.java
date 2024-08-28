package com.jung.spring.test.booking.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jung.spring.test.booking.domain.Booking;
import com.jung.spring.test.booking.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	
	public List<Booking> getBooking(){
		
		List<Booking> bookingList = bookingRepository.selectBooking();
		
		return bookingList;
		
	}
	
	public int deleteBookingList(int id) {
		
		return bookingRepository.deleteByObject(id);
		
	}
	
	public int createBookingList(Booking booking) {
		
		return bookingRepository.createByObject(booking);
		
	}
	
	
	public Booking getLookUpBooking(String name, String phoneNumber) {
		
		 return bookingRepository.selectLookUpBooking(name, phoneNumber);
		
	}
	
	
	
	
	
}
