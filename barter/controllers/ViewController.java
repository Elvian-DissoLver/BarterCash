package com.barter.barter.controllers;

import com.barter.barter.domain.Product;
import com.barter.barter.models.ProductRepository;
import com.barter.barter.models.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ViewController {
    private UserRepository userRepository;
    private ProductRepository productRepository;

    public ViewController(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Product> products = this.productRepository.findAll();
        model.addAttribute("product", products);
        return "index";
    }
}
