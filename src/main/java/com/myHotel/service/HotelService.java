package com.myHotel.service;

import com.myHotel.entity.Hotel;
import com.myHotel.entity.User;
import com.myHotel.repository.HotelJpaRepository;
import com.myHotel.repository.HotelCRUDRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelCRUDRepository hotelRepository;

    private final HotelJpaRepository hotelJpaRepository;

    private final UserService userService;

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public List<Hotel> getAll() {
//        return hotelRepository.findAll();
        return hotelJpaRepository.findAll();
    }

    public void hotelSell(User seller, Long hotelId) {
        Hotel hotel = hotelRepository.findHotelById(hotelId);
        hotel.setSeller(seller);
        hotel.setSale(true);
        hotelRepository.save(hotel);
    }

    public void hotelBuy(User buyer, Long hotelId) {
        Hotel hotel = hotelRepository.findHotelById(hotelId);
        hotel.setSeller(null);
        hotel.setSale(false);
        hotel.setOwner(buyer);
        hotelRepository.save(hotel);
    }

    public Hotel getById(Long hotelId) {
        return hotelRepository.findHotelById(hotelId);
    }

    public void hotelReturn(Long hotelId) {
        Hotel hotel = hotelRepository.findHotelById(hotelId);
        hotel.setSeller(null);
        hotel.setSale(false);
        hotelRepository.save(hotel);
    }

    public List<Hotel> getByOwner(User owner) {
        return hotelRepository.findHotelByOwner(owner);
    }

    public List<Hotel> getByIsSale() {
        return hotelRepository.findHotelBySellerIsNotNull();
    }

}
