package org.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/home")
public class CarResource {
    @RequestMapping( method = RequestMethod.GET)
    public String home(){
        return "/home.jsp";
    }
}
