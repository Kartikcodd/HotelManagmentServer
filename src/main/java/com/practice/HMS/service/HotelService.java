package com.practice.HMS.service;

import com.practice.HMS.dto.requestdto.HotelRequestDto;
import com.practice.HMS.dto.responsedto.HotelResponseDto;
import com.practice.HMS.entity.Hotel;
import com.practice.HMS.exception.HotelNotFoundException;
import com.practice.HMS.repository.HotelRepo;
import com.practice.HMS.service.messageService.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private EmailService emailService;
    public boolean AddHotel(HotelRequestDto hotelRequestDto) {
        Hotel hotel = convertedDtoToHotel(hotelRequestDto);
        hotelRepo.save(hotel);
        return true;

    }

    private Hotel convertedDtoToHotel(HotelRequestDto hotelRequestDto) {


        return Hotel.builder().hotelName(hotelRequestDto.getHotelName()).address(hotelRequestDto.getAddress()).contactNumber(hotelRequestDto.getContactNumber()).Status(hotelRequestDto.isStatus()).build();
    }

    public List<HotelResponseDto> getAll() {
        List<Hotel> hotels = new ArrayList<>(hotelRepo.findAll());
        String message = "Getting Hotel";
        emailService.sendNotification();

//        HotelResponseDto hotelResponseDto = new HotelResponseDto();
        return hotels.stream()
                .map(hotel -> new HotelResponseDto(
                        message,
                        hotel.getHotelName(),
                        hotel.isStatus(),
                        hotel.getRooms()
                ))
                .collect(Collectors.toList());
    }

    public HotelResponseDto getHotelByid(int id) throws HotelNotFoundException {
        Optional<Hotel> hotel = hotelRepo.findById(id);
        if(!hotel.isPresent()){
            throw new HotelNotFoundException("Hotel Not Found");
        }
        return convertedHotelToResponse(hotel.get());
    }

    private HotelResponseDto convertedHotelToResponse(Hotel hotel) {
        return HotelResponseDto.builder().hotelStatus(hotel.isStatus()).hotelName(hotel.getHotelName()).rooms(hotel.getRooms()).build();
    }
}