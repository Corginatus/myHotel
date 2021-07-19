package com.myHotel.repository;

import com.myHotel.entity.User;
import com.myHotel.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {
    public Worker findWorkerByMyUser(User user);

}
