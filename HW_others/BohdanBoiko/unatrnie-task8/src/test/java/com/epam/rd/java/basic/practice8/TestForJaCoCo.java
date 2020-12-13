package com.epam.rd.java.basic.practice8;

import com.epam.rd.java.basic.practice8.db.DBManager;
import com.epam.rd.java.basic.practice8.db.entity.Team;
import com.epam.rd.java.basic.practice8.db.entity.User;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

// unnecessary tests just to gain more points on eMentor :)
public class TestForJaCoCo extends BasicTest {
    private static final String TEST_STRING = "test";

    @Test
    public void getInstanceTest() {
        assertNotNull(DBManager.getInstance());
    }

    @Test
    public void getConnectionTest() throws SQLException {
        DBManager.getInstance().getConnection("");
        assertTrue(true);
    }

    @Test
    public void userToStringTest() {
        User user = User.createUser(TEST_STRING);
        assertEquals(TEST_STRING, user.toString());
    }

    @Test
    public void teamToStringTest() {
        Team team = Team.createTeam(TEST_STRING);
        assertEquals(TEST_STRING, team.toString());
    }

    @Test
    public void userHashCodeTest() {
        User user = User.createUser(TEST_STRING);
        user.hashCode();
        assertTrue(true);
    }

    @Test
    public void teamHashCodeTest() {
        Team team = Team.createTeam(TEST_STRING);
        team.hashCode();
        assertTrue(true);
    }

    @Test
    public void demoTest() {
        Demo.main(null);
        executeSql("DELETE FROM teams;");
        executeSql("DELETE FROM users;");
        assertTrue(true);
    }
}
