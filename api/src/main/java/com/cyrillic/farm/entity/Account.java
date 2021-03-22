package com.cyrillic.farm.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "account")
@JsonIgnoreProperties({"users"})
public class Account {
   
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "accounts")
    private Set<User> users;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "farm_id")
    private Farm farm;
    
    public Account() {
    }

    public Account(Customer customer, Farm farm) {
        this.customer = customer;
        this.farm = farm;
    }

    public Long getId() {
        return id;
    }

    public Set<User> getUsers() {
        return this.users;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }
}