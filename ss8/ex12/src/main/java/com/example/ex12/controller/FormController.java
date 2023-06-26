package com.example.ex12.controller;

import com.example.ex12.model.User;
import com.example.ex12.model.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/form")
@Controller
public class FormController {

    @GetMapping()
    public String showForm(Model model){
        model.addAttribute("userDTO", new UserDTO());

        return "/form";
    }

    @PostMapping()
    public String showResult(@Validated @ModelAttribute UserDTO userDTO, BindingResult  bindingResult, Model model){
        new UserDTO().validate(userDTO, bindingResult);
        if(bindingResult.hasErrors()){
            return "/form";
        }

        User userEntity =  new User();
        BeanUtils.copyProperties(userDTO, userEntity);

        return "/result";
    }





}
