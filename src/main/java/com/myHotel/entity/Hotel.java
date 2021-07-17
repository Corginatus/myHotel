package com.myHotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name; // Название отеля

    private int rooms;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private User owner;

//    @ManyToOne(cascade = CascadeType.ALL)
//    private User owner;

}
