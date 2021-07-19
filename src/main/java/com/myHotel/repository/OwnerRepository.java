package com.myHotel.repository;

import com.myHotel.entity.Owner;
import com.myHotel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    Owner findOwnerByMyUser(User user);
}
