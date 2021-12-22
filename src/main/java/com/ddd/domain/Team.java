package com.ddd.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@Builder
public class Team {

	private final TeamId teamId;

	private TeamName name;

	private int trophiesNumber;

	public void winChampionsLeague() {
		trophiesNumber++;
	}

	public void changeShortName(String shortName) {
		this.name = new TeamName(shortName, name.getFullName());
	}
}
