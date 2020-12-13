package com.epam.rd.java.basic.practice8.db.mock;

import java.util.Arrays;
import java.util.List;

import com.epam.rd.java.basic.practice8.db.TeamService;
import com.epam.rd.java.basic.practice8.db.entity.Team;

public class TeamServiceMock implements TeamService {

	public void insertTeam(Team team) {
		team.getId();
		team.setName("name");
	}

	public List<Team> findAllTeams() {
		return Arrays.asList(Team.createTeam("Mock1"), Team.createTeam("Mock2"));
	}

	public Team getTeam(String name) {
		return Team.createTeam(name);
	}

	public void deleteTeam(Team team) {
		team.setName("1");
	}

	public void updateTeam(Team team) {
		team.getName();
		team.getId();
		team.setName("1");
		team.setId(2);
	}

	@Override
	public void truncate() {
		//unneeded method
	}

}
