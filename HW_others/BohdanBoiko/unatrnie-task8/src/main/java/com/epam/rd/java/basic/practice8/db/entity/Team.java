package com.epam.rd.java.basic.practice8.db.entity;

import java.util.Objects;

public class Team {
    private int id;
    private String name;

    public Team() {
        name = "";
    }

    public Team(String name) {
        this.name = name;
    }

    public static Team createTeam(String login) {
        return new Team(login);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team user = (Team) o;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
