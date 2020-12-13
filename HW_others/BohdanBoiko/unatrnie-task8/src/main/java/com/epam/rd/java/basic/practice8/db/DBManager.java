package com.epam.rd.java.basic.practice8.db;

import com.epam.rd.java.basic.practice8.db.entity.Team;
import com.epam.rd.java.basic.practice8.db.entity.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBManager {
    private static DBManager dbManager;
    private final String connectionUrl;
    private static final Logger LOGGER = Logger.getGlobal();

    private static final String GET_USER_SQL = "SELECT * FROM users WHERE login=?;";
    private static final String GET_TEAM_SQL = "SELECT * FROM teams WHERE name=?;";
    private static final String INSERT_USER_SQL = "INSERT INTO users VALUES (DEFAULT, ?);";
    private static final String INSERT_TEAM_SQL = "INSERT INTO teams VALUES (DEFAULT, ?);";
    private static final String FIND_ALL_USERS_SQL = "SELECT * FROM users;";
    private static final String FIND_ALL_TEAMS_SQL = "SELECT * FROM teams;";
    private static final String SET_TEAMS_FOR_USER_SQL = "INSERT INTO users_teams VALUES (?, ?);";
    private static final String GET_USER_TEAMS_SQL = "SELECT * FROM teams WHERE id IN (SELECT team_id FROM users_teams WHERE user_id=?);";
    private static final String DELETE_TEAM_SQL = "DELETE FROM teams WHERE id=?;";
    private static final String UPDATE_TEAM_SQL = "UPDATE teams SET name=? WHERE id=?;";
    private static final String CLEAR_SQL = "DELETE FROM users; DELETE FROM teams;";

    private DBManager() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("app.properties"));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "there is no app.properties file", e);
        }
        connectionUrl = properties.getProperty("connection.url");
    }

    public static DBManager getInstance() {
        if (dbManager == null) {
            dbManager = new DBManager();
        }
        return dbManager;
    }

    public Connection getConnection(String connectionUrl) throws SQLException {
        DriverManager.registerDriver(new org.h2.Driver());
        return DriverManager.getConnection("jdbc:h2:~/test&username=sa&password=");
    }

    public User getUser(String login) {
        User user = new User();

        try (Connection connection = getConnection(connectionUrl);
             PreparedStatement statement = connection.prepareStatement(GET_USER_SQL)) {

            statement.setString(1, login);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    user = User.createUser(resultSet.getString("login"));
                    user.setId(resultSet.getInt("id"));
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "", e);
        }

        return user;
    }

    public Team getTeam(String name) {
        Team team = new Team();

        try (Connection connection = getConnection(connectionUrl);
             PreparedStatement statement = connection.prepareStatement(GET_TEAM_SQL)) {

            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    team = Team.createTeam(resultSet.getString("name"));
                    team.setId(resultSet.getInt("id"));
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "", e);
        }

        return team;
    }

    public void insertUser(User user) {
        try (Connection connection = getConnection(connectionUrl);
             PreparedStatement statement = connection.prepareStatement(INSERT_USER_SQL)) {
            statement.setString(1, user.getLogin());
            statement.execute();
            int id = getUser(user.getLogin()).getId();
            user.setId(id);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "", e);
        }
    }

    public void insertTeam(Team team) {
        try (Connection connection = getConnection(connectionUrl);
             PreparedStatement statement = connection.prepareStatement(INSERT_TEAM_SQL)) {
            statement.setString(1, team.getName());
            statement.execute();
            int id = getTeam(team.getName()).getId();
            team.setId(id);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "", e);
        }
    }

    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();

        try (Connection connection = getConnection(connectionUrl);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(FIND_ALL_USERS_SQL)) {

            while (resultSet.next()) {
                User user = User.createUser(resultSet.getString("login"));
                user.setId(resultSet.getInt("id"));
                users.add(user);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "", e);
        }

        return users;
    }

    public List<Team> findAllTeams() {
        List<Team> teams = new ArrayList<>();

        try (Connection connection = getConnection(connectionUrl);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(FIND_ALL_TEAMS_SQL)) {

            while (resultSet.next()) {
                Team team = Team.createTeam(resultSet.getString("name"));
                team.setId(resultSet.getInt("id"));
                teams.add(team);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "", e);
        }

        return teams;
    }

    public void setTeamsForUser(User user, Team... teams) {
        try (Connection connection = getConnection(connectionUrl)) {
            connection.setAutoCommit(false);
            for (Team team : teams) {
                try (PreparedStatement statement = connection.prepareStatement(SET_TEAMS_FOR_USER_SQL)) {
                    statement.setInt(1, user.getId());
                    statement.setInt(2, team.getId());
                    statement.execute();
                }
            }
            connection.commit();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "", e);
        }
    }

    public List<Team> getUserTeams(User user) {
        List<Team> teams = new ArrayList<>();

        try (Connection connection = getConnection(connectionUrl);
             PreparedStatement statement = connection.prepareStatement(GET_USER_TEAMS_SQL)) {
            statement.setInt(1, user.getId());
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Team team = Team.createTeam(resultSet.getString("name"));
                    team.setId(resultSet.getInt("id"));
                    teams.add(team);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "", e);
        }

        return teams;
    }

    public void deleteTeam(Team team) {
        try (Connection connection = getConnection(connectionUrl);
             PreparedStatement statement = connection.prepareStatement(DELETE_TEAM_SQL)) {
            statement.setInt(1, team.getId());
            statement.execute();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "", e);
        }
    }

    public void updateTeam(Team team) {
        try (Connection connection = getConnection(connectionUrl);
             PreparedStatement statement = connection.prepareStatement(UPDATE_TEAM_SQL)) {
            statement.setString(1, team.getName());
            statement.setInt(2, team.getId());
            statement.execute();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "", e);
        }
    }

    public void clear() {
        try (Connection connection = getConnection(connectionUrl);
             Statement statement = connection.createStatement()) {
            statement.execute(CLEAR_SQL);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "", e);
        }
    }
}
