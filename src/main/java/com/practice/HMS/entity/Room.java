package com.practice.HMS.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.practice.HMS.enums.RoomType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rooms")
@Builder
public class Room {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "room_type")
    private RoomType roomType;


    @Column(name = "amenities")
    private String amenities;

    @Column(name = "max_occupancy")
    private String maxOccupancy;

    @Column(name = "active")
    private Boolean active;


    @ManyToMany(mappedBy = "rooms",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Hotel> hotels;

}
