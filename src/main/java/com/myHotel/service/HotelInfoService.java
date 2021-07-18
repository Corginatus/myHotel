package com.myHotel.service;

import com.myHotel.entity.HotelInfo;
import com.myHotel.repository.HotelInfoRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Data
public class HotelInfoService {

    private final HotelInfoRepository hotelInfoRepository;

    public HotelInfo createInfo(HotelInfo hotelInfo) { return hotelInfoRepository.save(hotelInfo); }
}
