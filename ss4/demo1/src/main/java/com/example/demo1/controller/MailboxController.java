package com.example.demo1.controller;

import com.example.demo1.model.Mailbox;
import com.example.demo1.repository.MailboxRepository;
import com.example.demo1.service.IMailboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/mailbox")
public class MailboxController {
    @Autowired
    private IMailboxService iMailboxService;
    @RequestMapping()
    public String display(Model model){
        model.addAttribute("currentMailbox", iMailboxService.getCurrentMailbox());
        return "index";
    }

    @GetMapping("/showForm")
    public String showFormSetting(Model model){
        model.addAttribute("mailbox", new Mailbox());
        String[] languages = new String[]{"english", "japanese", "vietnamese", "chinese"};
        int[] sizes = new int[]{5,10,15,25,50,100};
        model.addAttribute("sizes", sizes);
        model.addAttribute("languages", languages);
        return "setting";
    }
    @PostMapping ("/submitForm")
    public String submitFormSetting(@ModelAttribute Mailbox mailbox){
        System.out.println(mailbox);
        iMailboxService.changeCurrentMailbox(mailbox);
        return "redirect:/mailbox";
    }
}
