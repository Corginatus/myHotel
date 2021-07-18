package com.myHotel.controller;

import com.myHotel.entity.Hotel;
import com.myHotel.entity.User;
import com.myHotel.service.HotelInfoService;
import com.myHotel.service.HotelService;
import com.myHotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelInfoService hotelInfoService;

    @GetMapping
    public ModelAndView controlPanel(ModelAndView model) {
        model.setViewName("admin_panel");
        return model;
    }

    @GetMapping("/hotel_history")
    public ModelAndView infoList(ModelAndView model) {
        model.addObject("hotels", hotelInfoService.getAll());
        model.setViewName("admin_hotels_info");
        return model;
    }

// Treatment --- /hotel... ---

    @PostMapping("/hotel_add")
    public ModelAndView createHotelFinish(ModelAndView model,
                                          @RequestParam(name = "ownerName") String owner,
                                          @RequestParam(name = "hotelName") String name,
                                          @RequestParam(name = "rooms") int rooms) {
        Hotel hotel = new Hotel();
        hotel.setRooms(rooms);
        hotel.setName(name);
        hotel.setOwner(userService.findByUsername(owner));
        model.addObject("hotel", hotelService.createHotel(hotel));
        model.setViewName("admin_users");
        return model;
    }

    @GetMapping("/hotel_add")
    public ModelAndView createHotel(ModelAndView model, @ModelAttribute(name = "hotel") Hotel hotel) {
        model.setViewName("admin_add_hotel");
        return model;
    }

    @GetMapping("/hotels")
    public ModelAndView hotelList(ModelAndView model) {
        model.addObject("hotelList", hotelService.getAll());
        model.setViewName("admin_hotels");
        return model;
    }

// Treatment --- /user ---

    @GetMapping("/users")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "admin_users";
    }

    @PostMapping("/users")
    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            userService.deleteUser(userId);
        }
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/gt/{userId}")
    public String  gtUser(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allUsers", userService.usergtList(userId));
        return "admin_users";
    }
}
