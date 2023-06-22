package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @RequestMapping()
    public String showAll(Model model) {
        model.addAttribute("products", iProductService.getAll());
        model.addAttribute("product", new Product());
        return "home";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "home";
    }

    @PostMapping("/create")
    public String createNewProduct(@ModelAttribute Product product, Model model) {
        model.addAttribute("addMessage", "New product added!");
        iProductService.createProduct(product);
        System.out.println(iProductService.getAll().size());
        return "redirect:/products";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("deleteId") int id) {
        System.out.println(id);
        iProductService.deleteProduct(id);
        return "redirect:/products";
    }

    @GetMapping("/{id}")
    public String showProductDetails(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if(iProductService.checkExistence(id)){
            model.addAttribute("product", iProductService.getProductById(id));
            return "details";
        } else {
             redirectAttributes.addFlashAttribute("message", "Invalid ID!");
            return "redirect:/products";
        }
    }

    @GetMapping("/edit{id}")
    public String showEditForm(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if(iProductService.checkExistence(id)){
            model.addAttribute("product", iProductService.getProductById(id));
            return "update";
        } else {
            redirectAttributes.addFlashAttribute("message", "Invalid ID!");
            return "redirect:/products";
        }
    }

    @PostMapping("/edit")
    public String updateProduct(@ModelAttribute Product product) {
        iProductService.editProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/search")
    public String searchProductByName(@RequestParam String productName, Model model) {
        System.out.println(productName);

        model.addAttribute("products", iProductService.searchByName(productName.toLowerCase()));
        return "home";
    }
}
