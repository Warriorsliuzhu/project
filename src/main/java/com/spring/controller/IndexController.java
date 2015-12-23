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

    @RequestMapping("num_index")
    public String index(Model model) {
        Blackfin blackfin = BlackfinComms.blackfin;
        try {
            if (blackfin != null) {
                Blackfin.Count count = blackfin.GetCurrentCount();
                model.addAttribute("count1", count.countLines.get(0).toString());
                model.addAttribute("count2", count.countLines.get(1).toString());
                int count1 = Integer.parseInt(count.countLines.get(1).toString());
                int count0 = Integer.parseInt(count.countLines.get(0).toString());
                model.addAttribute("count3", count1 - count0);
            } else {
                model.addAttribute("count1", 0);
                model.addAttribute("count2", 0);
                model.addAttribute("count3", 0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("_pagePath", _pagePath);
        return "layout";
    }

}
