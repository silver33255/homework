package com.epam.rd.java.basic.practice8.db.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import com.epam.rd.java.basic.practice8.db.UserService;
import com.epam.rd.java.basic.practice8.db.entity.Team;
import com.epam.rd.java.basic.practice8.db.entity.User;

public class UserServiceImpl implements UserService {

	private Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
	
	private String connectionURL;
	
	public UserServiceImpl() {
		try {
			Properties properties = readPropertiesFile("app.properties");
			this.connectionURL = properties.getProperty("connection.url");
		} catch (Exception e) {
			logger.severe(e.getMessage());
		}
	}
	
	public Connection getConnection(String url) {
		try {
			Connection connection = DriverManager.getConnection(url);// NOSONAR
			connection.setAutoCommit(false);
			return connection;
		} catch (Exception e) {
			logger.severe(e.getMessage());
			return null;
		}
	}
	
	public void insertUser(User user) {
		Connection connection = null;
		try {
			connection = getConnection(connectionURL);
			String query = "INSERT INTO Users(login) VALUES(?)";
			try (PreparedStatement ps = connection.prepareStatement(query);) {
				ps.setString(1, user.getLogin());
				ps.executeUpdate();
				connection.commit();
			}
			String getId = "SELECT id FROM Users WHERE login=?";
			try (PreparedStatement ps = connection.prepareStatement(getId);) {
				ps.setString(1, user.getLogin());
				try (ResultSet rs = ps.executeQuery();) {
					while (rs.next()) {
						user.setId(rs.getInt(1));
					}
					connection.commit();
				}
			}
		} catch (SQLException e) {
			logger.severe(e.getMessage());
			try {
				if (connection != null) {
					connection.commit();
					connection.close();
				}
			} catch (SQLException closeExc) {
				logger.severe(closeExc.getMessage());
			}
		}
	}

	public List<User> findAllUsers() {
		List<User> result = new ArrayList<>();
		Connection connection = null;
		try {
			connection = getConnection(connectionURL);
			String query = "SELECT id, login FROM Users";
			try (PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					result.add(new User(rs.getInt("id"), rs.getString("login")));
				}
			}
			connection.commit();
		} catch (SQLException e) {
			logger.severe(e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException rollbackExc) {
				logger.severe(rollbackExc.getMessage());
				return result;
			}
		} finally {
			try {
				if (connection != null) {
					connection.commit();
					connection.close();
				}
			} catch (SQLException closeExc) {
				logger.severe(closeExc.getMessage());
			}
		}
		return result;
	}

	public User getUser(String name) {
		Connection connection = null;
		try {
			connection = getConnection(connectionURL);
			String query = "SELECT id, login FROM Users WHERE login=?";
			try (PreparedStatement ps = connection.prepareStatement(query);) {
				ps.setString(1, name);
				try (ResultSet rs = ps.executeQuery();) {
					while (rs.next()) {
						return new User(rs.getInt("id"), rs.getString("login"));
					}
				}
			}
		} catch (SQLException e) {
			logger.severe(e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException rollbackExc) {
				logger.severe(rollbackExc.getMessage());
			}
		} finally {
			try {
				if (connection != null) {
					connection.commit();
					connection.close();
				}
			} catch (SQLException closeExc) {
				logger.severe(closeExc.getMessage());
			}
		}
		throw new NullPointerException("User not found for name " + name);
	}

	public void setTeamsForUser(User user, Team... teams) {
		String batchQuery = "INSERT INTO users_teams(user_id, team_id) values(?, ?)";
		Connection connection = getConnection(connectionURL);
		try (PreparedStatement ps = connection.prepareStatement(batchQuery)) {
			ps.setInt(1, user.getId());
			for (Team team : teams) {
				ps.setInt(2, team.getId());
				ps.addBatch();
			}
			ps.executeBatch();
			connection.commit();
		} catch (Exception e) {
			logger.severe(e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException rollbackExc) {
				logger.severe(rollbackExc.getMessage());
			}
		} finally {
			try {
				connection.close();
			} catch (SQLException closeExc) {
				logger.severe(closeExc.getMessage());
			}
		}
	}

	public List<Team> getUserTeams(User user) throws SQLException {
		List<Team> result = new ArrayList<>();
		String query = "SELECT Teams.id, Teams.name FROM Users JOIN users_teams ON Users.id = users_teams.user_id JOIN Teams ON Teams.id = users_teams.team_id WHERE Users.login=?";
		try (Connection connection = getConnection(connectionURL); PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, user.getLogin());
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					result.add(new Team(rs.getInt(1), rs.getString(2)));
				}
			}
			connection.commit();
		}
		return result;
	}
	
	public void truncate() {
		String query = "TRUNCATE TABLE Users";
		Connection connection = getConnection(connectionURL);
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			logger.severe(e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException rollbackExc) {
				logger.severe(rollbackExc.getMessage());
			}
		}
	}

	private Properties readPropertiesFile(String filename) throws IOException {
		Properties prop = null;
		try (FileInputStream fis = new FileInputStream(filename)) {
			prop = new Properties();
			prop.load(fis);
			return prop;
		} catch (Exception e) {
			logger.severe(e.getMessage());
		}
		throw new NullPointerException("Properties not found for file " + filename);
	}
	
}
