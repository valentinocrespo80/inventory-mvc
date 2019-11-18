package org.launchcode.inventorymvc.controllers;


import org.launchcode.inventorymvc.Service.UserService;
import org.launchcode.inventorymvc.models.User;
import org.launchcode.inventorymvc.models.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistration userRegistration(){
        return new UserRegistration();
    }

    @GetMapping
    public String showRegistrationForm(Model model){
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("User") @Valid UserRegistration userRegistration,
                                      BindingResult result){

        User existing = userService.findByEmail(userRegistration.getEmail());
        if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()){
            return "registration";
        }

        userService.save(userRegistration);
        return "redirect:/registration?success";
    }
}
