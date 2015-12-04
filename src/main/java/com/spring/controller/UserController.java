package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 15-5-28.
 */
@Controller
public class UserController {
    private final String _pagePath = "index.ftl";

//    @RequestMapping("")
//    public String index(Model model) {
//        System.out.println("----------------------");
//        model.addAttribute("test", "渴望光荣");
//
//        model.addAttribute("_pagePath", _pagePath);
//        return "layout";
//
//    }

//    @RequestMapping(value = "")
//    public String manageView(Model model) {
//        System.out.println("+++++++++++++++++++++++");
//        return "test";
//    }
}
