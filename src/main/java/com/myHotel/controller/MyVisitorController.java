package com.myHotel.controller;

import com.myHotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/visitor")
public class MyVisitorController {

    private final HotelService hotelService;

    @GetMapping("/home")
    public ModelAndView homePage(ModelAndView model, @RequestParam(defaultValue = "User") String name) {
        model.addObject("name", name);
        model.setViewName("visitor_home");
        return model;
    }

    @GetMapping("/help")
    public String help(){
        return "visitor_help";
    }

    @GetMapping("/hotels")
    public ModelAndView hotelList(ModelAndView model) {
        model.addObject("hotelList", hotelService.getAll());
        model.setViewName("visitor_hotels");
        return model;
    }

}
