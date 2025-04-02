package com.practice.HMS.service;

import com.practice.HMS.dto.requestdto.BookingRequestDto;
import com.practice.HMS.dto.responsedto.BookingResponseDto;
import com.practice.HMS.repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;
    public BookingResponseDto createBooking(BookingRequestDto bookingRequestDto){
return null;
    }

    public Boolean cancelledBooking(Integer bookingId){
        return true;
    }
}
