package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
//@EnableWebMvc
public class LoginController {

    @RequestMapping(value="/login", method= RequestMethod.GET)
    @ResponseBody
    public String login(@RequestParam String thing) {
        return thing + " You are a genius!";
    }

    @RequestMapping("/jsp/login")
    public String jspLogin(@RequestParam String thing, ModelMap modelMap) {
        // passing request param to Model which will be available in view
        modelMap.put("thing", thing);
        return "login";
    }
}
