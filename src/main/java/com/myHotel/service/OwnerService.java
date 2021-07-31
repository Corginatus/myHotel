package com.myHotel.service;

import com.myHotel.entity.Owner;
import com.myHotel.entity.User;
import com.myHotel.entity.Worker;
import com.myHotel.repository.OwnerRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
@AllArgsConstructor
public class OwnerService {

    OwnerRepository ownerRepository;

    public Owner save(Owner owner) { return ownerRepository.save(owner); }

    public Owner findByUser(User user) { return ownerRepository.findOwnerByMyUser(user); }

    public Owner addNewWorkplace(User user) {
        Owner owner = ownerRepository.findOwnerByMyUser(user);
        owner.addNewWorkplace();
        ownerRepository.save(owner);
        return owner;
    }

    public Owner addNewWorker(User user) {
        Owner owner = ownerRepository.findOwnerByMyUser(user);
        owner.addNewWorker();
        ownerRepository.save(owner);
        return owner;
    }

    public Owner delWorkplace(User user) {
        Owner owner = ownerRepository.findOwnerByMyUser(user);
        owner.delWorkplace();
        ownerRepository.save(owner);
        return owner;
    }


    public List<User> findFreeWorkplace() {
        List<Owner> ownerList = ownerRepository.findByFreeWorkplaceGreaterThan(0);
        List<User> userList = new ArrayList<>();
        for (Owner owner : ownerList) {
            userList.add(owner.getMyUser());
        }
        return userList;
    }

}
