package com.barter.barter.controllers;

import com.barter.barter.domain.Product;
import com.barter.barter.models.ProductRepository;
import com.barter.barter.models.UserRepository;
import com.barter.barter.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController

public class SiderController {
    private UserRepository userRepository;
    private ProductRepository productRepository;

    @Autowired
    public SiderController(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }


    @GetMapping("/listuser")
    public List<User> getAllUser() {
        List<User> users = this.userRepository.findAll();
        return this.userRepository.findAll();
    }

    @GetMapping("/products")
    public List<Product> getAllProduct() {
        //List<User> users = this.userRepository.findAll();
        return this.productRepository.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<User> create(@RequestBody User user) {
        userRepository.save(user);
        return userRepository.findAll();
    }

    @RequestMapping(value = "/affordable/{age}", method = RequestMethod.GET)
    public List<User> getAffordable(@PathVariable int age) {
        //return bookings.stream().filter(x -> x.getPricePerNight() <= price).collect(Collectors.toList());
        return userRepository.findByAgeLessThan(age);
    }


}
