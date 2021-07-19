package com.myHotel.controller;

import com.myHotel.entity.User;
import com.myHotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model, @RequestParam String myStatus) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }
        switch (myStatus) {
            case "OWNER":
                if (!userService.saveOwner(userForm)){
                    model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
                    return "registration";
                }
                break;
            case "WORKER":
                if (!userService.saveWorker(userForm)){
                    model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
                    return "registration";
                }
                break;
            case "VISITOR":
                if (!userService.saveVisitor(userForm)){
                    model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
                    return "registration";
                }
        }

        return "redirect:/";
    }
}
