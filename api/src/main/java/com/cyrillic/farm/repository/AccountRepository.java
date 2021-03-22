package com.cyrillic.farm.repository;

import java.util.Set;

import com.cyrillic.farm.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("select a from Account a join a.users u where u.id = :userId")
    public Set<Account> findAllByUser(Long userId);
    
}
