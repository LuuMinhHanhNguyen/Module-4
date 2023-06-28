package com.example.ex1.controller;

import com.example.ex1.model.Book;
import com.example.ex1.model.BorrowCode;
import com.example.ex1.service.IBookService;
import com.example.ex1.service.IBorrowCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;


@Controller
@RequestMapping("/return")
public class BorrowCodeController {
    @Autowired
    private IBorrowCodeService iBorrowCodeService;

    @Autowired
    private IBookService iBookService;

    @RequestMapping()
    public String showAllBorrowedCodes(Model model){
        model.addAttribute("codes",iBorrowCodeService.getAllBorrowCodes());
        return "/return";
    }

    @GetMapping("/codes")
    public String returnBorrowedBooks(@RequestParam Integer codes, RedirectAttributes redirectAttributes, Model model){

        try{
            BorrowCode borrowCode = iBorrowCodeService.findByBorrowCodes(codes).get();
            Book book = borrowCode.getBook();

            redirectAttributes.addFlashAttribute("cfBook", book);
            redirectAttributes.addFlashAttribute("cfBorrowCode", borrowCode);
            redirectAttributes.addFlashAttribute("cf", "Are you sure to return this book: ");

            return "redirect:/books";

        } catch (Exception e){
            redirectAttributes.addFlashAttribute("message", "Invalid borrowed codes! Please try again!");
        }
        return "redirect:/books";
    }

    @PostMapping("/codes")
    public String cfReturnBorrowedBooks(@RequestParam Integer codes, RedirectAttributes redirectAttributes) throws Exception {
        BorrowCode borrowCode = iBorrowCodeService.findByBorrowCodes(codes).get();
        borrowCode.setReturnDate(LocalDateTime.now());
        iBorrowCodeService.delete(borrowCode);
        redirectAttributes.addFlashAttribute("message", "Successfully return your book! Thank u!");
        return "redirect:/books";
    }
}
