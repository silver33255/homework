package com.epam.rd.java.basic.practice8.db;

import java.util.List;

import com.epam.rd.java.basic.practice8.db.entity.Team;

public interface TeamService {

	public void insertTeam(Team team);
	public List<Team> findAllTeams();
	public Team getTeam(String name);
	public void deleteTeam(Team team);
	public void updateTeam(Team team);
	public void truncate();
}
