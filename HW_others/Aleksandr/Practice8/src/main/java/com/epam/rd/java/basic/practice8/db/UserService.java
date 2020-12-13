package com.epam.rd.java.basic.practice8.db;

import java.sql.SQLException;
import java.util.List;

import com.epam.rd.java.basic.practice8.db.entity.Team;
import com.epam.rd.java.basic.practice8.db.entity.User;

public interface UserService {

	public void insertUser(User user);
	public List<User> findAllUsers();
	public User getUser(String name);
	public void setTeamsForUser(User user, Team... teams);
	public List<Team> getUserTeams(User user) throws SQLException;
	public void truncate();
	
}
