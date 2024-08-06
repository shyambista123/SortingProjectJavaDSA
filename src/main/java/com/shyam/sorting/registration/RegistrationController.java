package com.shyam.sorting.registration;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class RegistrationController {
    private final RegistrationService registrationService;

    @ModelAttribute
    public RegistrationRequest registrationRequest(){
        return new RegistrationRequest();
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("registrationRequest") RegistrationRequest registrationRequest, Model model) {
        try {
            registrationService.register(registrationRequest);
            return "redirect:/login";
        } catch (Exception e) {
//            model.addAttribute("error", "Registration failed. Please try again.");
            return "register";
        }
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
