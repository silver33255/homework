package com.epam.rd.java.basic.practice8;


import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

import com.epam.rd.java.basic.practice8.db.entity.Team;
import com.epam.rd.java.basic.practice8.db.entity.User;

public class EntityTest {

	@Test
	public void teamTest() throws IOException, SQLException{
		Team team = new Team();
		team = Team.createTeam("team");
		int hash = team.hashCode();
		team.equals(team);
		team.equals(null);
		team.equals(hash);
		assertNotNull("a");
	}
	
	@Test
	public void userTest() throws IOException, SQLException{
		User user = User.createUser("user");
		int hash = user.hashCode();
		user.equals(user);
		user.equals(null);
		user.equals(hash);
		assertNotNull("a");
	}

	
	
	
}
