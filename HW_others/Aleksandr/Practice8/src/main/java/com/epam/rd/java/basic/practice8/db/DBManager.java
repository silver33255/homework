package com.epam.rd.java.basic.practice8.db;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import com.epam.rd.java.basic.practice8.db.entity.Team;
import com.epam.rd.java.basic.practice8.db.entity.User;
import com.epam.rd.java.basic.practice8.db.impl.TeamServiceImpl;
import com.epam.rd.java.basic.practice8.db.impl.UserServiceImpl;
import com.epam.rd.java.basic.practice8.db.mock.TeamServiceMock;
import com.epam.rd.java.basic.practice8.db.mock.UserServiceMock;

public class DBManager {

	private UserService userService;
	private TeamService teamService;

	private static Logger logger = Logger.getLogger(DBManager.class.getName());

	private DBManager() {
		userService = new UserServiceImpl();
		teamService = new TeamServiceImpl();
	}

	public void setMockServices() {
		userService = new UserServiceMock();
		teamService = new TeamServiceMock();
	}
	
	public UserService getUserService() {
		return userService;
	}

	public TeamService getTeamService() {
		return teamService;
	}

	public void truncateTables() {
		userService.truncate();
		teamService.truncate();
	}
	
	public static DBManager getInstance() {
		try {
			return new DBManager();
		} catch (Exception e) {
			logger.severe(e.getMessage());
			return null;
		}
	}

	public void insertUser(User user) {
		this.userService.insertUser(user);
	}

	public List<User> findAllUsers() {
		return this.userService.findAllUsers();
	}

	public void insertTeam(Team team) {
		this.teamService.insertTeam(team);
	}

	public List<Team> findAllTeams() {
		return this.teamService.findAllTeams();
	}

	public User getUser(String name) {
		return this.userService.getUser(name);
	}

	public Team getTeam(String name) {
		return this.teamService.getTeam(name);
	}

	public void setTeamsForUser(User user, Team... teams) {
		this.userService.setTeamsForUser(user, teams);
	}

	public List<Team> getUserTeams(User user) throws SQLException {
		return this.userService.getUserTeams(user);
	}

	public void deleteTeam(Team team) {
		this.teamService.deleteTeam(team);
	}

	public void updateTeam(Team team) {
		this.teamService.updateTeam(team);
	}

}
