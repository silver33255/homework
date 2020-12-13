package com.epam.rd.java.basic.practice8;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

import com.epam.rd.java.basic.practice8.db.DBManager;

public class DemoTest {

	@Test(timeout=3000)
	public void demoTest() throws IOException, SQLException {
		DBManager manager = DBManager.getInstance();
		manager.truncateTables();
		Demo.main(new String[0]);
		assertNotNull("");
	}
	
}
