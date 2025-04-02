package com.practice.HMS.controller;

import com.practice.HMS.dto.requestdto.HotelRequestDto;
import com.practice.HMS.dto.responsedto.HotelResponseDto;
import com.practice.HMS.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    //Admin
    @PostMapping("/")
    public Boolean AddHotel(@RequestBody HotelRequestDto hotelRequestDto) {
        return hotelService.AddHotel(hotelRequestDto);
    }

    //customer

    @GetMapping("/")
    public List<HotelResponseDto> getAll(){
        return hotelService.getAll();
    }

    //customer

    @GetMapping("/id")
    public ResponseEntity<HotelResponseDto> getHotelById(@RequestParam int id){

        try{

            HotelResponseDto hotelResponseDto=  hotelService.getHotelByid(id);
            return new ResponseEntity<>(hotelResponseDto,HttpStatus.OK);
        }
        catch (Exception e){
            HotelResponseDto hotelResponseDto = new HotelResponseDto();
            hotelResponseDto.setError(e.getMessage());
            return new ResponseEntity<>(hotelResponseDto,HttpStatus.BAD_REQUEST);
        }


    }
}
