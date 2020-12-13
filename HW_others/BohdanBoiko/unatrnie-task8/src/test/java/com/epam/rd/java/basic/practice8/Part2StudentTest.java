package com.epam.rd.java.basic.practice8;

import com.epam.rd.java.basic.practice8.db.entity.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Part2StudentTest extends BasicTest {
    private static final String TEST_NAME = "test";

    @Before
    public void setUp() {
        executeSql("INSERT INTO teams VALUES (DEFAULT, 'test1');");
        executeSql("INSERT INTO teams VALUES (DEFAULT, 'test2');");
        executeSql("INSERT INTO teams VALUES (DEFAULT, 'test3');");
        executeSql("INSERT INTO teams VALUES (DEFAULT, 'test4');");
    }

    @After
    public void tearDown() {
        executeSql("DELETE FROM teams WHERE name='test1';");
        executeSql("DELETE FROM teams WHERE name='test2';");
        executeSql("DELETE FROM teams WHERE name='test3';");
        executeSql("DELETE FROM teams WHERE name='test4';");
        executeSql("DELETE FROM teams WHERE name='" + TEST_NAME + "';");
    }

    @Test
    public void insertTeamTest() {
        Team team = Team.createTeam(TEST_NAME);
        DB_MANAGER.insertTeam(team);
        assertTrue(executeSqlQuery("SELECT * FROM teams WHERE name='" + TEST_NAME + "';"));
    }

    @Test
    public void getTeamTest() {
        Team team = Team.createTeam("test1");
        assertEquals(team, DB_MANAGER.getTeam(team.getName()));
    }

    @Test
    public void findAllTeamsTest() {
        List<Team> teams = DB_MANAGER.findAllTeams();
        assertEquals("test1", teams.get(0).getName());
        assertEquals("test2", teams.get(1).getName());
        assertEquals("test3", teams.get(2).getName());
        assertEquals("test4", teams.get(3).getName());
    }

}