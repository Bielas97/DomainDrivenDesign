package com.ddd.application;

import com.ddd.domain.TeamName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
public class AddTeamRequest {

	private final TeamName name;

}
