package com.myHotel.repository;

import com.myHotel.entity.Hotel;
import com.myHotel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Integer> {
//    List<Hotel> findAllByOwner(Long owner);
    List<Hotel> findHotelByOwner(User owner);

}
