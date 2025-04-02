package com.practice.HMS.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hotel_room_mapping")
@Builder
public class Hotel_Room_Mapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "hotel_id")
    private int hotelId;
    @Column(name = "room_id")
    private int roomId;
    @Column(name = "total_room")
    private int totalRoom;
}
