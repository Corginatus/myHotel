package com.myHotel.repository;

import com.myHotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelJpaRepository extends JpaRepository<Hotel, Integer> {
//    List<Hotel> findHotelBySaleIsTrue();
}
