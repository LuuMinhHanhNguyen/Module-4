package com.example.blog1.controller;

import com.example.blog1.model.Category;
import com.example.blog1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RequestMapping("/categories")
@Controller
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;
    @RequestMapping()
    public String showAllCategories(Model model){
        model.addAttribute("categories", iCategoryService.findAllCategories());
        return "/category/home";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new Category());
        return "/category/add";
    }

    @PostMapping("/create")
    public String createNewCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "New blog added!");
        iCategoryService.save(category);
        return "redirect:/categories";
    }

    @PostMapping ("/delete")
    public String deleteCategory(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        if(iCategoryService.checkIDExistence(id)){
            iCategoryService.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Delete Successfully!");
        } else{
            redirectAttributes.addFlashAttribute("message", "Invalid ID!");
        }
        return "redirect:/categories";
    }


    @GetMapping("/update/{id}")
    public String showEditForm(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        if(iCategoryService.checkIDExistence(id)){
            model.addAttribute("category", iCategoryService.findById(id));
            return "/category/edit";
        } else{
            redirectAttributes.addFlashAttribute("message", "Invalid ID!");
            return "redirect:/categories";
        }
    }

    @PostMapping("/update")
    public String updateCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Update Successfully!");
        return "redirect:/categories";
    }
}
