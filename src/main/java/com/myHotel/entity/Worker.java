package com.myHotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_worker")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private User myUser;

    @ManyToOne
    private User employer;

    @ManyToOne
    private Hotel hotel;

    private String name;

    private String surname;

    private int ex; // опыт работы

    private TimeType timeType;



}
