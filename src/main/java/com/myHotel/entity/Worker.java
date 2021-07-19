package com.myHotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @OneToOne
    private User employer;

    private String name;

    private String surname;

    private int ex; // опыт работы

    private boolean sex; // true - муж / false - жен

    private TimeType timeType;

}
