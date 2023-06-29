package com.example.ex1.controller;

import com.example.ex1.model.Cart;
import com.example.ex1.model.Product;
import com.example.ex1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
@SessionAttributes("cart")
public class ProductController {

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @Autowired
    private IProductService iProductService;

    @RequestMapping
    public String showAllProducts(Model model) {
        model.addAttribute("products", iProductService.findAll());
        return "/home";
    }

    @GetMapping("/details/{id}")
    public String showProductDetails(@PathVariable Integer id, Model model) {
        if (iProductService.findById(id) == null) {
            model.addAttribute("msg", "Invalid ID!");
        }
        model.addAttribute("product", iProductService.findById(id));
        return "/details";
    }

    @GetMapping("/{id}")
    public String addProductToCart(@PathVariable Integer id,
                                   @RequestParam Integer quantity,
                                   @SessionAttribute("cart") Cart cart,
                                   Model model) {
        if (iProductService.findById(id) == null) {
            model.addAttribute("msg", "Invalid ID!");
        }

        cart.addProduct(iProductService.findById(id), quantity);
        model.addAttribute("cartList", cart.getProducts());
        model.addAttribute("cart", cart);
        return "/cart";
    }

}
