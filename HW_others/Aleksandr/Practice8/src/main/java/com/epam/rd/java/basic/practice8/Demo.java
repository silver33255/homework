package com.epam.rd.java.basic.practice8;

import java.sql.SQLException;
import java.util.List;

import com.epam.rd.java.basic.practice8.db.DBManager;
import com.epam.rd.java.basic.practice8.db.entity.Team;
import com.epam.rd.java.basic.practice8.db.entity.User;

public class Demo {

	private static final String DIVIDER = "===========================";
	
	private static void printList(List<?> list) {
		println(list.toString());
	}

	public static void main(String[] args) throws SQLException {

		// users ==> [ivanov]

		// teams ==> [teamA]

		DBManager dbManager = DBManager.getInstance();

		// Part 1

		dbManager.insertUser(User.createUser("petrov"));

		dbManager.insertUser(User.createUser("obama"));

		printList(dbManager.findAllUsers());

		// users ==> [ivanov, petrov, obama]

		println(DIVIDER);

		// Part 2
		

		dbManager.insertTeam(Team.createTeam("teamB"));

		dbManager.insertTeam(Team.createTeam("teamC"));

		printList(dbManager.findAllTeams());

		// teams ==> [teamA, teamB, teamC]

		println(DIVIDER);

		// Part 3

		User userPetrov = dbManager.getUser("petrov");

		User userIvanov = dbManager.getUser("ivanov");

		User userObama = dbManager.getUser("obama");

		Team teamA = dbManager.getTeam("teamA");

		Team teamB = dbManager.getTeam("teamB");

		Team teamC = dbManager.getTeam("teamC");

		// method setTeamsForUser must implement transaction!

		dbManager.setTeamsForUser(userIvanov, teamA);
		dbManager.setTeamsForUser(userPetrov, teamA, teamB);
		dbManager.setTeamsForUser(userObama, teamA, teamB, teamC);

		for (User user : dbManager.findAllUsers()) {
			printList(dbManager.getUserTeams(user));
			println("~~~~~");

		}

		// teamA
		// teamA teamB
		// teamA teamB teamC

		println(DIVIDER);

		// Part 4

		// on delete cascade!

		dbManager.deleteTeam(teamA);

		// Part 5

		teamC.setName("teamX");

		dbManager.updateTeam(teamC);

		printList(dbManager.findAllTeams());

		// teams ==> [teamB, teamX]

	}
	
	
	private static void println(String message) {
		System.out.println(message);//NOSONAR
	}

}
