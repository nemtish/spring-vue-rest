package com.cyrillic.farm.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.cyrillic.farm.entity.Account;
import com.cyrillic.farm.entity.Customer;
import com.cyrillic.farm.entity.Farm;
import com.cyrillic.farm.entity.User;
import com.cyrillic.farm.service.FarmService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FarmController extends BaseController {
    
    @Autowired
    private FarmService farmService;


    @GetMapping("/account")
    public Set<Account> getUserAccounts() {
        return farmService.getUserAccounts(getAuthenticatedUser());
    }

    @GetMapping("/farm")
    public Set<Farm> getUserFarms() {
        var accounts = farmService.getUserAccounts(getAuthenticatedUser());
        return accounts.stream().map(a -> a.getFarm()).collect(Collectors.toSet());
    }

    @GetMapping("/customer")
    public List<Customer> getCustomers() {
        return farmService.getCustomers();
    }

    @CrossOrigin
    @GetMapping("/user")
    public List<User> getUsers() {
        return farmService.getUsers();

    }
}
