package com.epam.rd.java.basic.practice8;

import com.epam.rd.java.basic.practice8.db.entity.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Part4StudentTest extends BasicTest {
    private static final String TEST_NAME = "test";

    @Before
    public void setUp() {
        executeSql("INSERT INTO teams VALUES (DEFAULT, '" + TEST_NAME + "');");
    }

    @After
    public void tearDown() {
        executeSql("DELETE FROM teams WHERE name='" + TEST_NAME + "';");
    }

    @Test
    public void deleteTeamTest() {
        Team team = DB_MANAGER.getTeam(TEST_NAME);
        DB_MANAGER.deleteTeam(team);
        assertEquals("depends on DBManager#getTeam(Team)!", "", DB_MANAGER.getTeam(TEST_NAME).getName());
    }

    @Test
    public void clearTest() {
        DB_MANAGER.clear();
        assertEquals("depends on DBManager#getTeam(Team)!", "", DB_MANAGER.getTeam(TEST_NAME).getName());
    }
}