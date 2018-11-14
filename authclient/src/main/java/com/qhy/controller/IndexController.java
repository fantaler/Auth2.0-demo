package com.qhy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class IndexController {

    @RequestMapping("/indexpage")
    public String toShowUser() {
        System.out.println("-------------------------------------");
        return "index";
    }
}
