package com.epam.rd.java.basic.practice8;

import com.epam.rd.java.basic.practice8.db.entity.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Part5StudentTest extends BasicTest {
    private static final String TEST_NAME = "test";
    private static final String NEW_NAME = "NEW test";

    @Before
    public void setUp() {
        executeSql("INSERT INTO teams VALUES (DEFAULT, '" + TEST_NAME + "');");
    }

    @After
    public void tearDown() {
        executeSql("DELETE FROM teams WHERE name='" + TEST_NAME + "';");
        executeSql("DELETE FROM teams WHERE name='" + NEW_NAME + "';");
    }

    @Test
    public void updateTeamTest() {
        Team team = DB_MANAGER.getTeam(TEST_NAME);
        team.setName(NEW_NAME);
        DB_MANAGER.updateTeam(team);
        assertEquals("depends on DBManager#getTeam(Team)!", NEW_NAME, DB_MANAGER.getTeam(NEW_NAME).getName());
    }
}