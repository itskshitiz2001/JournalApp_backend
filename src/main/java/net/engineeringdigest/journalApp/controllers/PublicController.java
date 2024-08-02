package net.engineeringdigest.journalApp.controllers;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/public")
@RestController


public class PublicController {

    @Autowired
    private UserService userService;
    @GetMapping("/health-check")
    public String healthcheck()
    {
        return "Ok";
    }

    @PostMapping("/create-user")
    public void createUser(@RequestBody User user)
    {
        userService.saveNewUser(user);
    }


}
