package com.example.ex1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("condiment")

public class CondimentController {
    @RequestMapping("")
    public String show() {
        return "index";
    }

    @RequestMapping("save")
    public String save(@RequestParam(value = "condiment", required = false) String condiment, Model model) {

        System.out.println(condiment);
        model.addAttribute("result", condiment);
        return "index";
    }

}
