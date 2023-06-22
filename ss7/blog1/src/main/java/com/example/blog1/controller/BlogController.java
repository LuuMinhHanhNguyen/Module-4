package com.example.blog1.controller;


import com.example.blog1.model.Blog;
import com.example.blog1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @RequestMapping("")
    public String showAll(Model model) {
        model.addAttribute("blogs", iBlogService.findAll());

        return "/home";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
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
