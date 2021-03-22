package com.cyrillic.farm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "farm")
@JsonIgnoreProperties({"account"})
public class Farm {
    
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(mappedBy = "farm")
    private Account account;

    public Farm() {
        super();
    }

    public Farm(String name) {
        this.name = name;
    }
    
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Farm [name=" + name + "]";
    }
}