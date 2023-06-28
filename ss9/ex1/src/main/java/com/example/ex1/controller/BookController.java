package com.example.ex1.controller;

import com.example.ex1.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService iBookService;

    @RequestMapping
    public String showAllBooks(Model model) {
        model.addAttribute("books", iBookService.getAllBooks());
        return "/home";
    }


    @GetMapping("/details/{id}")
    public String showBookDetails(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("book", iBookService.findById(id).get());
            return "/details";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Invalid Book ID!");
            return "redirect:/books";
        }
    }

    @GetMapping("/borrow/{id}")
    public String borrowBooks(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        try {
            redirectAttributes.addFlashAttribute("message",
                    "Book borrowed! Your borrowed code is: " + iBookService.borrow(id));
        } catch (Exception e){
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "Invalid book ID!");
        }
        return "redirect:/books";
    }
}
