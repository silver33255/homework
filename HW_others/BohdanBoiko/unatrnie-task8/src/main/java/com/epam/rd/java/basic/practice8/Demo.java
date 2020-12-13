package com.epam.rd.java.basic.practice8;

import com.epam.rd.java.basic.practice8.db.DBManager;
import com.epam.rd.java.basic.practice8.db.entity.Team;
import com.epam.rd.java.basic.practice8.db.entity.User;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    private static final DBManager DB_MANAGER;

    static {
        DB_MANAGER = DBManager.getInstance();
        DB_MANAGER.clear();
        DB_MANAGER.insertUser(User.createUser("ivanov"));
        DB_MANAGER.insertTeam(Team.createTeam("teamA"));
    }

    public static void main(String[] args) {
        part1();
        part2();
        List<Team> teams = part3();
        part4(teams.get(0));
        part5(teams.get(2));
    }

    // users  ==> [ivanov, petrov, obama]
    private static void part1() {
        printPartNumber(1);
        DB_MANAGER.insertUser(User.createUser("petrov"));
        DB_MANAGER.insertUser(User.createUser("obama"));
        System.out.println(DB_MANAGER.findAllUsers());
    }

    // teams ==> [teamA, teamB, teamC]
    private static void part2() {
        printPartNumber(2);
        DB_MANAGER.insertTeam(Team.createTeam("teamB"));
        DB_MANAGER.insertTeam(Team.createTeam("teamC"));
        System.out.println(DB_MANAGER.findAllTeams());
    }

    // teamA
    // teamA teamB
    // teamA teamB teamC
    // <method setTeamsForUser must implement transaction!>
    private static List<Team> part3() {
        printPartNumber(3);
        User userPetrov = DB_MANAGER.getUser("petrov");
        User userIvanov = DB_MANAGER.getUser("ivanov");
        User userObama = DB_MANAGER.getUser("obama");
        Team teamA = DB_MANAGER.getTeam("teamA");
        Team teamB = DB_MANAGER.getTeam("teamB");
        Team teamC = DB_MANAGER.getTeam("teamC");

        DB_MANAGER.setTeamsForUser(userIvanov, teamA);
        DB_MANAGER.setTeamsForUser(userPetrov, teamA, teamB);
        DB_MANAGER.setTeamsForUser(userObama, teamA, teamB, teamC);
        for (User user : DB_MANAGER.findAllUsers()) {
            System.out.println(DB_MANAGER.getUserTeams(user));
        }

        List<Team> teams = new ArrayList<>();
        teams.add(teamA);
        teams.add(teamB);
        teams.add(teamC);
        return teams;
    }

    // <on delete cascade!>
    private static void part4(Team teamA) {
        printPartNumber(4);
        DB_MANAGER.deleteTeam(teamA);
    }

    // teams ==> [teamB, teamX]
    private static void part5(Team teamC) {
        printPartNumber(5);
        teamC.setName("teamX");
        DB_MANAGER.updateTeam(teamC);
        System.out.println(DB_MANAGER.findAllTeams());
    }

    private static void printPartNumber(int number) {
        System.out.println();
        System.out.println("===========Part" + number + "===========");
    }
}