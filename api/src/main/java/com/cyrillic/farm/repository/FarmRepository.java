package com.cyrillic.farm.repository;

import com.cyrillic.farm.entity.Farm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmRepository extends JpaRepository<Farm, Long> {
    
}
