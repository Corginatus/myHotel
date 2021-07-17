package com.myHotel.service;

import com.myHotel.entity.Hotel;
import com.myHotel.entity.User;
import com.myHotel.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

//    public List<Hotel> getAll() {
//        return hotelRepository.findAll();
//    }

    public List<Hotel> getByOwner(User owner) {
        return hotelRepository.findHotelByOwner(owner);
    }

}
