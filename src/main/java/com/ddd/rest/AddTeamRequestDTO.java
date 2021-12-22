package com.ddd.rest;

import com.ddd.application.AddTeamRequest;
import com.ddd.domain.TeamName;

public class AddTeamRequestDTO {

	public String shortName;

	public String fullName;

	public AddTeamRequest toDomain() {
		return new AddTeamRequest(new TeamName(shortName, fullName));
	}

}
