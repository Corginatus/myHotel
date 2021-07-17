package com.myHotel.controller;

import com.myHotel.entity.Hotel;
import com.myHotel.entity.User;
import com.myHotel.service.HotelService;
import com.myHotel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/owner")
public class MyOwnerController {

    private final HotelService hotelService;

    private final UserService userService;

    @GetMapping("/home")
    public ModelAndView homePage(ModelAndView model, @RequestParam(defaultValue = "User") String name) {
        model.addObject("name", name);
        model.setViewName("owner_home");
        return model;
    }

    @PostMapping("/create_hotel")
    public ModelAndView createHotelFinish(ModelAndView model,
                                          @AuthenticationPrincipal User owner,
                                          @RequestParam(name = "name") String name,
                                          @RequestParam(name = "rooms") int rooms) {
        Hotel hotel = new Hotel();
        hotel.setRooms(rooms);
        hotel.setName(name);
        hotel.setOwner(owner);
        model.addObject("hotel", hotelService.createHotel(hotel));
        model.setViewName("owner_home");
        return model;
    }

    @GetMapping("/create_hotel")
    public ModelAndView createHotel(ModelAndView model, @ModelAttribute(name = "hotel") Hotel hotel) {
        model.setViewName("owner_create_hotel");
        return model;
    }

    @GetMapping("/hotel_list")
    public ModelAndView hotelList(ModelAndView model, @AuthenticationPrincipal User owner) {
        List<Hotel> hotelList = hotelService.getByOwner(owner);
        model.addObject("hotelList", hotelList);
        model.setViewName("owner_hotel_list");
        return model;
    }

}
