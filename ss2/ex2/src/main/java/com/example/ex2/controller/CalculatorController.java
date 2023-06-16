package com.example.ex2.controller;

import com.example.ex2.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/calculator")
@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService iCalculatorService;
    @GetMapping()
    public String calculate(){
        return "index";
    }

    @PostMapping()
    public String calculate(@RequestParam double firstNum, @RequestParam double secondNum, @RequestParam String operator, Model model){
        try {
            iCalculatorService.calculate(firstNum, secondNum, operator);
            model.addAttribute("result", iCalculatorService.calculate(firstNum,secondNum,operator));

        } catch (Exception e) {
            model.addAttribute("result","Cannot divine by 0");

        }
        return "index";
    }
}
