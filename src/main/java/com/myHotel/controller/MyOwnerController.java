package com.myHotel.controller;

import com.myHotel.entity.Hotel;
import com.myHotel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/owner")
public class MyOwnerController {

    private final UserService ownerService;

    @GetMapping("/home")
    public ModelAndView homePage(ModelAndView model, @RequestParam(defaultValue = "User") String name) {
        model.addObject("name", name);
        model.setViewName("owner_home");
        return model;
    }

//    @PostMapping("/create_hotel")
//    public String createHotel(Long id,
//                                   @RequestParam(defaultValue = "Error") String name,
//                                   @RequestParam(defaultValue = "123") int rooms) {
//        Hotel hotel = new Hotel();
//        hotel.setName(name);
//        hotel.setRooms(rooms);
//        ownerService.addHotel(hotel, id);
//        return "redirect:/owner/home";
//    }
}
