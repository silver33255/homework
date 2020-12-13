package com.epam.rd.java.basic.practice8.db.mock;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.epam.rd.java.basic.practice8.db.UserService;
import com.epam.rd.java.basic.practice8.db.entity.Team;
import com.epam.rd.java.basic.practice8.db.entity.User;

public class UserServiceMock implements UserService {

	public void insertUser(User user) {
		//unneeded method
	}

	public List<User> findAllUsers() {
		return Arrays.asList(User.createUser("Mock1"), User.createUser("Mock2"));
	}

	public User getUser(String name) {
		return User.createUser(name);
	}

	public void setTeamsForUser(User user, Team... teams) {
		//unneeded method
	}

	public List<Team> getUserTeams(User user) throws SQLException {
		return Arrays.asList(Team.createTeam("Mock1"), Team.createTeam("Mock2"));
	}

	@Override
	public void truncate() {
		//unneeded method
	}
}
