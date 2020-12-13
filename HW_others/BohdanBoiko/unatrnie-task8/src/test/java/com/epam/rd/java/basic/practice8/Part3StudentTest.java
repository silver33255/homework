package com.epam.rd.java.basic.practice8;

import com.epam.rd.java.basic.practice8.db.entity.Team;
import com.epam.rd.java.basic.practice8.db.entity.User;
import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Part3StudentTest extends BasicTest {
    private static final String TEST_LOGIN = "testName";

    @After
    public void tearDown() {
        executeSql("DELETE FROM users WHERE login='" + TEST_LOGIN + "';");
        executeSql("DELETE FROM teams WHERE name='test1';");
        executeSql("DELETE FROM teams WHERE name='test2';");
        executeSql("DELETE FROM teams WHERE name='test3';");
    }

    @Test
    public void setTeamsForUserTest() {
        User user = User.createUser(TEST_LOGIN);
        Team team1 = Team.createTeam("test1");
        Team team2 = Team.createTeam("test2");
        Team team3 = Team.createTeam("test3");
        DB_MANAGER.insertUser(user);
        DB_MANAGER.insertTeam(team1);
        DB_MANAGER.insertTeam(team2);
        DB_MANAGER.insertTeam(team3);
        DB_MANAGER.setTeamsForUser(user, team1, team2, team3);
        assertTrue(executeSqlQuery("SELECT user_id FROM users_teams WHERE team_id=" + team1.getId() + ";"));
        assertTrue(executeSqlQuery("SELECT user_id FROM users_teams WHERE team_id=" + team2.getId() + ";"));
        assertTrue(executeSqlQuery("SELECT user_id FROM users_teams WHERE team_id=" + team3.getId() + ";"));
    }

    @Test
    public void getTeamsForUserTest() {
        User user = User.createUser(TEST_LOGIN);
        Team team1 = Team.createTeam("test1");
        Team team2 = Team.createTeam("test2");
        Team team3 = Team.createTeam("test3");
        DB_MANAGER.insertUser(user);
        DB_MANAGER.insertTeam(team1);
        DB_MANAGER.insertTeam(team2);
        DB_MANAGER.insertTeam(team3);
        DB_MANAGER.setTeamsForUser(user, team1, team2, team3);
        List<Team> teams = DB_MANAGER.getUserTeams(user);
        assertEquals("depends on DBManager#setTeamsForUser(User, Team...)!", team1, teams.get(0));
        assertEquals("depends on DBManager#setTeamsForUser(User, Team...)!", team2, teams.get(1));
        assertEquals("depends on DBManager#setTeamsForUser(User, Team...)!", team3, teams.get(2));
    }
}