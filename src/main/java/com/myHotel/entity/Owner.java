package com.myHotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private User myUser;

    private int workplace=0;

    private int freeWorkplace=0;

    public void addNewWorkplace() {
        this.freeWorkplace++;
        this.workplace++;
    }

    public void delWorkplace() {
        this.freeWorkplace--;
        this.workplace--;
    }

    public void addNewWorker() {
        this.freeWorkplace--;
    }

    public void delWorker() {
        this.freeWorkplace++;
    }

}
