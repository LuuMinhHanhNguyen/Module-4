package com.example.demo.controller;
import com.example.demo.service.IExchangeMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class ExchangeController {
    @Autowired
    private IExchangeMoneyService iExchangeMoneyService;
    @GetMapping("/exchange")
    public String exchangeMoney(){
        return "index";
    }
    @PostMapping ("/exchange")
    public String exchangeMoney(@RequestParam double rate, @RequestParam double amount, HttpServletRequest request, HttpServletResponse response, Model model){

        if(iExchangeMoneyService.exchangeMoney(amount, rate) == -1){
            model.addAttribute("result", "Please enter a positive number!");
        } else {
            model.addAttribute("result", iExchangeMoneyService.exchangeMoney(amount, rate));
        }
        // updated
        return "index";
    }
}
