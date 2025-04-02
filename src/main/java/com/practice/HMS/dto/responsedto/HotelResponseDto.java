package com.practice.HMS.dto.responsedto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.practice.HMS.entity.Room;
import lombok.*;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelResponseDto {

    String error;

    String hotelName;

    boolean hotelStatus;

    List<Room> rooms;


    public HotelResponseDto(String message, String hotelName, boolean status, List<Room> rooms) {
        this.error = message;
        this.hotelName = hotelName;
        this.hotelStatus = status;
        this.rooms = rooms;
    }
}
