package com.myHotel.controller;

import com.myHotel.entity.Hotel;
import com.myHotel.entity.User;
import com.myHotel.service.HotelInfoService;
import com.myHotel.service.HotelService;
import com.myHotel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/owner")
public class MyOwnerController {

    private final HotelService hotelService;

    private final HotelInfoService hotelInfoService;

    private final UserService userService;

    @GetMapping("/home")
    public ModelAndView homePage(ModelAndView model, @RequestParam(defaultValue = "User") String name) {
        model.addObject("name", name);
        model.setViewName("owner_home");
        return model;
    }

    @GetMapping("/hotel_free")
    public ModelAndView freeHotels(ModelAndView model, @AuthenticationPrincipal User owner) {
        List<Hotel> hotelList = hotelService.getByIsSale();
        model.addObject("hotelList", hotelList);
        model.addObject("myOwner", owner);
        model.setViewName("owner_hotel_free");
        return model;
    }

    @PostMapping("/hotel_free")
    public String sellHotel(@AuthenticationPrincipal User buyer,
                              @RequestParam(name = "hotel") Long hotelId) {
        Date date = new Date();
        Hotel hotel = hotelService.getById(hotelId);
        hotelInfoService.createInfo(date.toString(),hotel, buyer, hotel.getOwner());
        hotelService.hotelBuy(buyer, hotelId);
        return "redirect:/owner/home";
    }

    @PostMapping("/hotel_sell")
    public String updateHotel(@AuthenticationPrincipal User seller,
                              @RequestParam(name = "hotel") Long hotelId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("sell")) {
            hotelService.hotelSell(seller, hotelId);
        }
        if (action.equals("return")) {
            hotelService.hotelReturn(hotelId);
        }
        return "redirect:/owner/hotel_sell";
    }

    @GetMapping("/hotel_sell")
    public ModelAndView sellHotel(ModelAndView model, @AuthenticationPrincipal User seller) {
        List<Hotel> hotelList = hotelService.getByOwner(seller);
        model.addObject("hotelList", hotelList);
        model.addObject("seller", seller);
        model.setViewName("owner_sell_hotel");
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
