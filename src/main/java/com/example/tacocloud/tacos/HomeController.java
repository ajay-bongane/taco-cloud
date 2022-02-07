package com.example.tacocloud.tacos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/gjgjgjg") // Replaced by WebConfig config class for view controller
    public String home(){
        return "home";
    }
}
