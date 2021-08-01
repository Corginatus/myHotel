package com.myHotel.repository;

import com.myHotel.entity.User;
import com.myHotel.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {
    Worker findWorkerByMyUser(User user);
    List<Worker> findWorkerByEmployer(User user);
}
