package com.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Administrator on 15-5-28.
 */
@Controller
public class LoginController {
    private final String _pagePath = "index.ftl";
    private Logger logger= LoggerFactory.getLogger(LoginController.class);

//    @RequestMapping("")
//    public String index(Model model) {
//        System.out.println("----------------------");
//        model.addAttribute("test", "渴望光荣");
//
//        model.addAttribute("_pagePath", _pagePath);
//        return "layout";
//
//    }

    @RequestMapping(value = "")
    public String index(Model model) {
        System.out.println("+++++++++++++++++++++++");
        return "test";
    }

    @RequestMapping(value = "login")
    public String manageView(Model model) {
        return "login";
    }

    @RequestMapping(value = "register")
    public String register(Model model) {
        return "register";
    }
}
