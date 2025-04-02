package com.practice.HMS.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

//@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hotel")
@Builder
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "hotel_name", unique = true)
    private String hotelName;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "status")
    private boolean Status;

    @JoinTable(name = "hotel_room_mapping", joinColumns = @JoinColumn(name = "hotel_id"),inverseJoinColumns = @JoinColumn(name = "room_id"))
    @ManyToMany

    List<Room> rooms;


}
