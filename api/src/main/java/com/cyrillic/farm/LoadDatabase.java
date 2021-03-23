package com.cyrillic.farm;

import java.util.Set;

import com.cyrillic.farm.entity.Account;
import com.cyrillic.farm.entity.Customer;
import com.cyrillic.farm.entity.Farm;
import com.cyrillic.farm.entity.User;
import com.cyrillic.farm.repository.AccountRepository;
import com.cyrillic.farm.repository.CustomerRepository;
import com.cyrillic.farm.repository.FarmRepository;
import com.cyrillic.farm.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
class LoadDatabase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FarmRepository farmRepository;

    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
	private PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initDatabase() {

        return args -> {
            
            User user1 = userRepository.save(new User("user1@cyrillic.com", passwordEncoder.encode("secret")));
            User user2 = userRepository.save(new User("user2@cyrillic.com", passwordEncoder.encode("secret")));

            Farm farm1 = farmRepository.save(new Farm("Farm 1"));
            Farm farm2 = farmRepository.save(new Farm("Farm 2"));

            Customer customer1 = customerRepository.save(new Customer("Customer", "One"));
            Customer customer2 = customerRepository.save(new Customer("Customer", "Two"));

            Account account1 = accountRepository.save(new Account(customer1, farm1));
            Account account2 = accountRepository.save(new Account(customer2, farm2));

            // relations
            user1.setAccounts(Set.of(account1, account2));
            userRepository.save(user1);

            user2.setAccounts(Set.of(account2));
            userRepository.save(user2);
        };
    }
}
