package com.myHotel.repository;

import com.myHotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelJpaRepository extends JpaRepository<Hotel, Integer> {
}
