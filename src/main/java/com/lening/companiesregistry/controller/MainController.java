package com.lening.companiesregistry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("/toList")
    public String toMain(){
        return "compan_list";
    }
}
