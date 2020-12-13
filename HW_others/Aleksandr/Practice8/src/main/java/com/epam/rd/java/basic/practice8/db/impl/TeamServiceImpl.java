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

import com.epam.rd.java.basic.practice8.db.TeamService;
import com.epam.rd.java.basic.practice8.db.entity.Team;

public class TeamServiceImpl implements TeamService {

	private Logger logger = Logger.getLogger(TeamServiceImpl.class.getName());

	private String connectionURL;

	public TeamServiceImpl() {
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

	public void insertTeam(Team team) {
		Connection connection = null;
		try {
			connection = getConnection(connectionURL);
			String query = "INSERT INTO Teams(name) VALUES(?)";
			try (PreparedStatement ps = connection.prepareStatement(query);) {
				ps.setString(1, team.getName());
				ps.executeUpdate();
				connection.commit();
			}
			String getId = "SELECT id FROM Teams WHERE name=?";
			try (PreparedStatement ps = connection.prepareStatement(getId);) {
				ps.setString(1, team.getName());
				try (ResultSet rs = ps.executeQuery();) {
					while (rs.next()) {
						team.setId(rs.getInt(1));
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

	public List<Team> findAllTeams() {
		List<Team> result = new ArrayList<>();
		Connection connection = null;
		try {
			connection = getConnection(connectionURL);
			String query = "SELECT id, name FROM Teams";
			try (PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					result.add(new Team(rs.getInt("id"), rs.getString("name")));
				}
				connection.commit();
			}
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

	public Team getTeam(String name) {
		Connection connection = null;
		try {
			connection = getConnection(connectionURL);
			String query = "SELECT id, name FROM Teams WHERE name=?";
			try (PreparedStatement ps = connection.prepareStatement(query);) {
				ps.setString(1, name);
				try (ResultSet rs = ps.executeQuery();) {
					while (rs.next()) {
						return new Team(rs.getInt("id"), rs.getString("name"));
					}
					connection.commit();
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
		throw new NullPointerException("Team not found for name " + name);
	}

	public void deleteTeam(Team team) {
		String query = "DELETE FROM Teams WHERE id=?";
		Connection connection = getConnection(connectionURL);
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, team.getId());
			ps.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
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

	public void updateTeam(Team team) {
		String query = "UPDATE Teams SET name=? WHERE id=?";
		Connection connection = getConnection(connectionURL);
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, team.getName());
			ps.setInt(2, team.getId());
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

	public void truncate() {
		String query = "TRUNCATE TABLE Teams";
		String query2 = "TRUNCATE TABLE users_teams";
		Connection connection = getConnection(connectionURL);
		try (PreparedStatement ps = connection.prepareStatement(query);PreparedStatement ps2 = connection.prepareStatement(query2)) {
			ps.executeUpdate();
			ps2.executeUpdate();
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
