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
    public String login(@RequestParam String userName) {
        return "redirect:/dummy";//userName + " You are a genius!";
    }

    @RequestMapping(value="/dummy", method= RequestMethod.GET)
    @ResponseBody
    public String dummy() {
        return "You are a dummy!";
    }

    @RequestMapping(value="/jsplogin", method= RequestMethod.GET)
    public String jspLogin(@RequestParam String name, ModelMap modelMap) {
        // passing request param to Model which will be available in view
        modelMap.put("name", name);
        return "loginPage";
    }

}
