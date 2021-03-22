package com.cyrillic.farm.repository;

import com.cyrillic.farm.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
