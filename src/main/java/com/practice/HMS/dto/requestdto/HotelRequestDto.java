package com.practice.HMS.dto.requestdto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HotelRequestDto {
    private String hotelName;

    private String address;

    private String contactNumber;

    private boolean Status;
}
