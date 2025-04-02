package com.practice.HMS.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.practice.HMS.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "booking")
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "booking_status")
    private BookingStatus bookingStatus;

    @Column(name = "hotel_id")
    private int hotelId;

    @Column(name = "room_id")
    private int roomId;

    @Column(name = "booking_amount")
    private int bookingAmount;

    @Column(name = "is_prepaid")
    private  Boolean isPrepaid;

    @Column(name = "check_in")
    LocalDate checkIn;

    @Column(name = "check_out")
    LocalDate checkOut;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Customer customer;

}
