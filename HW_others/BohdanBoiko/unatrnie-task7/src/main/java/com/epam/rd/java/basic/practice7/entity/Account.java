package com.epam.rd.java.basic.practice7.entity;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String name;
    private int id;
    private String depositor;
    private String country;
    private List<Valet> valets = new ArrayList<>();

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getDepositor() {
        return depositor;
    }

    public String getCountry() {
        return country;
    }

    public List<Valet> getValets() {
        return valets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepositor(String depositor) {
        this.depositor = depositor;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setValets(List<Valet> valets) {
        this.valets = valets;
    }

    public void addValet(Valet valet) {
        valets.add(valet);
    }
}
