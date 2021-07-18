package com.myHotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_hotel_info")
public class HotelInfo {

//
//  Запись о продаже/покупке отеля
//

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // Id операции

    private String date;

    @OneToOne
    private Hotel hotel;

    @OneToOne
    private User seller;

    @OneToOne
    private User buyer;


}
