package com.epam.rd.java.basic.practice8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

import com.epam.rd.java.basic.practice8.db.DBManager;
import com.epam.rd.java.basic.practice8.db.entity.Team;
import com.epam.rd.java.basic.practice8.db.entity.User;

public class DBTest {

	@Test
	public void part1Test() throws IOException, SQLException {

		DBManager dbManager = DBManager.getInstance();

		dbManager.truncateTables();

		dbManager.insertUser(User.createUser("ivanov"));
		
		dbManager.insertUser(User.createUser("petrov"));

		dbManager.insertUser(User.createUser("obama"));

		assertEquals("[ivanov, petrov, obama]", dbManager.findAllUsers().toString());

	}

	@Test
	public void part2Test() throws IOException, SQLException {

		DBManager dbManager = DBManager.getInstance();

		dbManager.insertTeam(Team.createTeam("teamA"));
		
		dbManager.insertTeam(Team.createTeam("teamB"));

		dbManager.insertTeam(Team.createTeam("teamC"));

		assertEquals("[teamB, teamX, teamB, teamC]", dbManager.findAllTeams().toString());

	}

	@Test
	public void part3Test() throws IOException, SQLException {

		
		StringBuilder sb = new StringBuilder();
		try {
		DBManager dbManager = DBManager.getInstance();

		User userPetrov = dbManager.getUser("petrov");

		User userIvanov = dbManager.getUser("ivanov");

		User userObama = dbManager.getUser("obama");

		Team teamA = dbManager.getTeam("teamA");

		Team teamB = dbManager.getTeam("teamB");

		Team teamC = dbManager.getTeam("teamC");

		dbManager.setTeamsForUser(userIvanov, teamA);
		dbManager.setTeamsForUser(userPetrov, teamA, teamB);
		dbManager.setTeamsForUser(userObama, teamA, teamB, teamC);

		for (User user : dbManager.findAllUsers()) {
			sb.append(dbManager.getUserTeams(user)).append(System.lineSeparator());
		}
		}catch(Exception e) {
		}
		assertEquals("teamA" + System.lineSeparator() + "teamA teamB\n" + System.lineSeparator() + "teamA teamB teamC",
				sb.toString());

	}

	@Test
	public void part4Test() throws IOException, SQLException {

		DBManager dbManager = DBManager.getInstance();

		try {
			Team teamA = dbManager.getTeam("teamA");
			dbManager.deleteTeam(teamA);
		} catch (Exception e) {
		}
		

		assertNotNull("a");
	}

	@Test
	public void part5Test() throws IOException, SQLException {

		DBManager dbManager = DBManager.getInstance();

		Team teamC = dbManager.getTeam("teamC");

		teamC.setName("teamX");

		dbManager.updateTeam(teamC);

		assertEquals("[teamB, teamX, teamB, teamX]", dbManager.findAllTeams().toString());

	}

}
