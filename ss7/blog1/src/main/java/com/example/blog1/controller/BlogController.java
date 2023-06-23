package com.example.blog1.controller;


import com.example.blog1.model.Blog;
import com.example.blog1.service.IBlogService;
import com.example.blog1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Date;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @RequestMapping("")
    public String showAll(@PageableDefault(size = 2, sort = "date")Pageable pageable, Model model) {

        model.addAttribute("blogs", iBlogService.findAll(pageable));
        model.addAttribute("categories", iCategoryService.findAllCategories());

        return "/home";
    }

    @GetMapping("/choice")
    public String showByChoices(@RequestParam Integer searchedCategory, Model model, Pageable pageable){

        model.addAttribute("blogs", iBlogService.findBlogsByCategory_IdAndFlagDeleteFalse(searchedCategory, pageable));
        model.addAttribute("categories", iCategoryService.findAllCategories());
        System.out.println("im here");
        System.out.println(searchedCategory);
        return "/home";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", iCategoryService.findAllCategories());
        System.out.println(iCategoryService.findAllCategories());
        //yyyyy
        return "/add";
    }

    @PostMapping("/create")
    public String createNewBlog(@ModelAttribute Blog blog, Model model, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("success", "New blog added!");
        iBlogService.save(blog);

        return "redirect:/blogs";
    }

    @GetMapping("/details/{id}")
    public String showProductDetails(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        if(iBlogService.checkIDExistence(id)){
            model.addAttribute("blog", iBlogService.findById(id));
            System.out.println(iBlogService.findById(id).getCategory().getName());
            return "details";
        } else {
            redirectAttributes.addFlashAttribute("invalidIDMessage", "Invalid ID!");
            return "redirect:/blogs";
        }
    }

    @PostMapping ("/delete")
    public String deleteBlog(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        if(iBlogService.checkIDExistence(id)){
             iBlogService.deleteById(id);
            System.out.println("hihi" + id);
           redirectAttributes.addAttribute("successDelete", "Delete Successfully!");
        } else{
            redirectAttributes.addAttribute("errorDelete", "Invalid ID!");
        }
        return "redirect:/blogs";
    }

    @GetMapping("/update/{id}")
    public String showEditForm(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        if(iBlogService.checkIDExistence(id)){
            model.addAttribute("blog", iBlogService.findById(id));
            model.addAttribute("categories", iCategoryService.findAllCategories());
            return "edit";
        } else{
            redirectAttributes.addAttribute("errorUpdate", "Invalid ID!");
            return "redirect:/blogs";
        }
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Blog blog) {
        System.out.println(blog.getId());
        iBlogService.save(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam("title") String title, Model model) {
        // update
        System.out.println(iBlogService.searchByTitle(title));
        model.addAttribute("blogs", iBlogService.searchByTitle(title));
        return "/home";
    }

}
