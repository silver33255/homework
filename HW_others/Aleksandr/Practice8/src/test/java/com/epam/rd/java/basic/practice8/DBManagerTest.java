package com.epam.rd.java.basic.practice8;


import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.epam.rd.java.basic.practice8.db.DBManager;
import com.epam.rd.java.basic.practice8.db.entity.Team;
import com.epam.rd.java.basic.practice8.db.entity.User;

public class DBManagerTest {

	@Test
	public void managerTest() throws IOException, SQLException{
		DBManager mock = DBManager.getInstance();
		
		mock.getUserService();
		
		mock.getTeamService();
		
		mock.setMockServices();
		
		mock.insertTeam(Team.createTeam("mock"));
		
		mock.insertUser(User.createUser("mock"));
		
		mock.deleteTeam(Team.createTeam("mock"));
		
		List<Team> mockTeams = mock.findAllTeams();
		
		assertEquals(mockTeams.get(0), Team.createTeam("Mock1"));
		assertEquals(mockTeams.get(1), Team.createTeam("Mock2"));
		
		
		List<User> mockUsers = mock.findAllUsers();
		assertEquals(mockUsers.get(0), User.createUser("Mock1"));
		assertEquals(mockUsers.get(1), User.createUser("Mock2"));
		
		
		assertEquals(mock.getTeam("mock"), Team.createTeam("mock"));
		
		assertEquals(mock.getUser("mock"), User.createUser("mock"));
		
		mock.setTeamsForUser(User.createUser("mock"), Team.createTeam("mock"));
		
		mockTeams = mock.getUserTeams(User.createUser("mock"));
		
		assertEquals(mockTeams.get(0), Team.createTeam("Mock1"));
		assertEquals(mockTeams.get(1), Team.createTeam("Mock2"));
		
		mock.updateTeam(Team.createTeam("mock"));
	}
	
}
