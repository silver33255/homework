package com.epam.rd.java.basic.practice8;

import com.epam.rd.java.basic.practice8.db.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Part1StudentTest extends BasicTest {
    private static final String TEST_LOGIN = "test";

    @Before
    public void setUp() {
        executeSql("INSERT INTO users VALUES (DEFAULT, 'test1');");
        executeSql("INSERT INTO users VALUES (DEFAULT, 'test2');");
        executeSql("INSERT INTO users VALUES (DEFAULT, 'test3');");
        executeSql("INSERT INTO users VALUES (DEFAULT, 'test4');");
    }

    @After
    public void tearDown() {
        executeSql("DELETE FROM users WHERE login='test1';");
        executeSql("DELETE FROM users WHERE login='test2';");
        executeSql("DELETE FROM users WHERE login='test3';");
        executeSql("DELETE FROM users WHERE login='test4';");
        executeSql("DELETE FROM users WHERE login='" + TEST_LOGIN + "';");
    }

    @Test
    public void insertUserTest() {
        User user = User.createUser("");
        user.setLogin(TEST_LOGIN);
        DB_MANAGER.insertUser(user);
        assertTrue(executeSqlQuery("SELECT * FROM users WHERE login='" + TEST_LOGIN + "';"));
    }

    @Test
    public void getUserTest() {
        User user = User.createUser("test1");
        assertEquals(user, DB_MANAGER.getUser(user.getLogin()));
    }

    @Test
    public void findAllUsersTest() {
        List<User> users = DB_MANAGER.findAllUsers();
        assertEquals("test1", users.get(0).getLogin());
        assertEquals("test2", users.get(1).getLogin());
        assertEquals("test3", users.get(2).getLogin());
        assertEquals("test4", users.get(3).getLogin());
    }
}