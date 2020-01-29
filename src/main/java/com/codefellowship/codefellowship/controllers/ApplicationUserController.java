package com.codefellowship.codefellowship.controllers;

import com.codefellowship.codefellowship.models.ApplicationUser;
import com.codefellowship.codefellowship.models.ApplicationUserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;

@Controller
public class ApplicationUserController {


    // followed along with the video from class 16, and 17 as well as referenced the class 16/17 demo for this project
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public RedirectView createNewApplicationUser(String username, String password){
        ApplicationUser createNew = new ApplicationUser(username, passwordEncoder.encode(password));

        //this will save to the database
        applicationUserRepository.save(createNew);

        // The TA gave me the two lines below when we were troubleshooting an issue with database
        Authentication authentication = new UsernamePasswordAuthenticationToken(createNew, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new RedirectView("/login");
    }


    @GetMapping("/login")
    public String showLoginForm(){

        return "login";
    }

   @GetMapping("/userDetails")
    public String getOneUsersDetails( Principal principal, Model model){
        ApplicationUser oneUser = applicationUserRepository.findByUsername(principal.getName());

        model.addAttribute("userName", oneUser.getUsername());
        model.addAttribute("userId", oneUser.id);
        model.addAttribute("user", oneUser);
        return "userDetails";


   }


}
