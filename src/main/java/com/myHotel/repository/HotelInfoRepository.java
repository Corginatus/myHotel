package com.myHotel.repository;

import com.myHotel.entity.HotelInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelInfoRepository extends JpaRepository<HotelInfo, Integer> {
}
