package com.cyrillic.farm.service;

import java.util.List;
import java.util.Set;

import com.cyrillic.farm.entity.Account;
import com.cyrillic.farm.entity.Customer;
import com.cyrillic.farm.entity.User;
import com.cyrillic.farm.repository.AccountRepository;
import com.cyrillic.farm.repository.CustomerRepository;
import com.cyrillic.farm.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;
    
    /**
     * Get all users
     * @return
     */
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    /**
     * Get all customers
     * @return
     */
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    /**
     * Get all user accounts
     * @param user
     * @return
     */
    public Set<Account> getUserAccounts(User user) {
        return accountRepository.findAllByUser(user.getId());
    }

    /**
     * Find user by emai
     * @param userEmail
     * @return
     */
    public User getUserByEmail(String username) {
        return userRepository.findByUsername(username);
    }
}
