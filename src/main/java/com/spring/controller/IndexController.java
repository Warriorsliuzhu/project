package com.spring.controller;

import com.spring.server.BlackfinComms;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.co.irisys.Blackfin;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Administrator on 15-5-28.
 */
@Controller
public class IndexController {
    private final String _pagePath = "index.ftl";

    @RequestMapping("findNum")
    public String index(Model model) {
        Blackfin blackfin = BlackfinComms.blackfin;
        try {
            Blackfin.Count count = blackfin.GetCurrentCount();
            System.out.println(new Date() + "count 1 " + count.countLines.get(0).toString() + " count 2 " + count.countLines.get(1).toString());
            model.addAttribute("count1", count.countLines.get(0).toString());
            model.addAttribute("count2", count.countLines.get(1).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("_pagePath", _pagePath);
        return "layout";
    }

//    @RequestMapping(value = "")
//    public String manageView(Model model) {
//        System.out.println("+++++++++++++++++++++++");
//        return "test";
//    }
}
