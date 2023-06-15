package com.example.ex2.controller;

import com.example.ex2.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService iDictionaryService;
    @GetMapping (value = "/dictionary")
    public String search(){

        return "index";
    }

    @PostMapping  ("/dictionary")
    public String search(@RequestParam String word, Model model){
        model.addAttribute("result",iDictionaryService.lookUp(word));
        return "index";
    }
}
