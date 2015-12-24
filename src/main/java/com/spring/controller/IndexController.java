package com.spring.controller;

import com.spring.server.BlackfinComms;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.co.irisys.Blackfin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
                Calendar start = Calendar.getInstance();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date date = format.parse("2015-12-24 00:00:00");
                start.setTime(date);
                Calendar end = Calendar.getInstance();
                end.setTime(new Date());
                List<Blackfin.Count> counts = blackfin.GetCounts(start, end);
                model.addAttribute("count1", count.countLines.get(0).toString());
                model.addAttribute("count2", count.countLines.get(1).toString());
                int count1 = Integer.parseInt(count.countLines.get(1).toString());
                int count0 = Integer.parseInt(count.countLines.get(0).toString());
                model.addAttribute("count3", count1 - count0);
            } else {
                model.addAttribute("count1", 0);
                model.addAttribute("count2", 0);
                model.addAttribute("count3", 0);
                model.addAttribute("mess", "设备正在初始化，请等待...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        model.addAttribute("_pagePath", _pagePath);
        return "layout";
    }

}
