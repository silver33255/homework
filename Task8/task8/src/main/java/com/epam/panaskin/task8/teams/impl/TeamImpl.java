package com.epam.panaskin.task8.teams.impl;

import com.epam.panaskin.task8.teams.ITeam;

public class TeamImpl implements ITeam {
    private String name;

    public TeamImpl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public boolean equals(Object obj) {
        return this.hashCode() == ((ITeam) obj).getName().hashCode();
    }

    public int hashCode() {
        return this.getName().hashCode();
    }

}
