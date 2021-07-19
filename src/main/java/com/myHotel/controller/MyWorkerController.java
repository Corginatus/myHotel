package com.myHotel.controller;

import com.myHotel.entity.Hotel;
import com.myHotel.entity.TimeType;
import com.myHotel.entity.User;
import com.myHotel.entity.Worker;
import com.myHotel.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/worker")
public class MyWorkerController {

    private final WorkerService workerService;

    @GetMapping("/home")
    public ModelAndView homePage(ModelAndView model, @RequestParam(defaultValue = "User") String name) {
        model.addObject("name", name);
        model.setViewName("worker_home");
        return model;
    }

    @GetMapping("/help")
    public String help(){
        return "worker_help";
    }

    @PostMapping("/update")
    public String updateProfile(@RequestParam int ex,
                                      @RequestParam String name,
                                      @RequestParam String surname,
                                      @RequestParam TimeType timeType,
                                      @AuthenticationPrincipal User myUser) {
        workerService.update(ex, name, surname, timeType, myUser);
        return "redirect:/worker/home";
    }

    @GetMapping("/update")
    public ModelAndView edit(ModelAndView model, @AuthenticationPrincipal User user) {
        model.addObject("worker", workerService.findByUser(user));
        model.setViewName("worker_edit_info");
        return model;
    }

    @GetMapping("/profile")
    public ModelAndView profile(ModelAndView model, @AuthenticationPrincipal User user) {
        Worker worker = workerService.findByUser(user);
        if (worker == null) {
            model.addObject("user", user);
            model.setViewName("worker_new_info");
        }
        else {
            model.addObject("worker", worker);
            model.setViewName("worker_profile");
        }
        return model;
    }

    @PostMapping("/profile")
    public ModelAndView createProfile(ModelAndView model,
                                      @RequestParam int ex,
                                      @RequestParam String name,
                                      @RequestParam String surname,
                                      @RequestParam String human,
                                      @RequestParam TimeType timeType,
                                      @AuthenticationPrincipal User myUser) {
        Worker worker = workerService.findByUser(myUser);
        worker.setMyUser(myUser);
        worker.setEx(ex);
        worker.setName(name);
        worker.setSurname(surname);
        switch (human) {
            case "MAN":
                worker.setSex(true);
                break;
            case "FEMALE":
                worker.setSex(false);
                break;
            default:
                return model;
        }
//        worker.setSex((human == "MAN") ? true : false);
        worker.setTimeType(timeType);
        model.addObject("worker", workerService.save(worker));
        model.setViewName("worker_home");
        return model;
    }


}
