package com.myHotel.service;

import com.myHotel.entity.User;
import com.myHotel.entity.Worker;
import com.myHotel.repository.WorkerRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class WorkerService {

    private final WorkerRepository workerRepository;

    public Worker findByUser(User user) {
        return workerRepository.findWorkerByMyUser(user);
    }

    public Worker save(Worker worker) {
        return workerRepository.save(worker);
    }

}
