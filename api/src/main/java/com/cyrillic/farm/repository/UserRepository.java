package com.cyrillic.farm.repository;

import com.cyrillic.farm.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    public User findByUsername(String username);
}
