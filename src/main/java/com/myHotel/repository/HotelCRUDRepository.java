package com.myHotel.repository;

import com.myHotel.entity.Hotel;
import com.myHotel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface HotelCRUDRepository extends CrudRepository<Hotel, Integer> {
    List<Hotel> findHotelByOwner(User owner);
    Hotel findHotelByOwnerId(Long owner);
    Hotel findHotelById(Long id);
    List<Hotel> findHotelBySellerIsNotNull();
}
