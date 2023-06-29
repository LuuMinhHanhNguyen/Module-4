package com.example.ex1.controller;

import com.example.ex1.model.Cart;
import com.example.ex1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private IProductService iProductService;

    @RequestMapping
    public String showCart(@SessionAttribute("cart") Cart cart, Model model){
        model.addAttribute("cartList", cart.getProducts());
        model.addAttribute("cart", cart);
        return "/cart";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@SessionAttribute("cart") Cart cart,@PathVariable Integer id, HttpSession session){

        cart.deleteProduct(iProductService.findById(id));
        System.out.println(cart.getProducts().size());

        session.setAttribute("cart", cart);

        return "redirect:/carts";
    }

    @PostMapping("/checkout")
    public String checkout(HttpSession session){

        session.removeAttribute("cart");

        return "redirect:/products";
    }
}
