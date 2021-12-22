package com.ddd.rest;

import com.ddd.application.TeamApplicationService;
import com.ddd.domain.Team;
import com.ddd.domain.TeamId;
import com.ddd.domain.TeamStore;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teams")
public class TeamController {

	private final TeamApplicationService service;

	private final TeamStore repository;

	@PostMapping
	public TeamDTO addTeam(@RequestBody AddTeamRequestDTO requestDTO) {
		final Team team = service.addTeam(requestDTO.toDomain());
		return TeamDTO.builder()
				.id(team.getTeamId().getInternal())
				.shortName(team.getName().getShortName())
				.fullName(team.getName().getFullName())
				.trophiesNumber(team.getTrophiesNumber())
				.build();
	}

	@PostMapping("/{id}/champion")
	public TeamDTO winChampionsLeague(@PathVariable("id") long teamId) {
		final TeamId id = TeamId.valueOf(teamId);
		service.winChampionsLeague(id);
		final Team team = repository.findById(id).orElseThrow(() -> new RuntimeException("team not found"));
		return TeamDTO.builder()
				.id(team.getTeamId().getInternal())
				.shortName(team.getName().getShortName())
				.fullName(team.getName().getFullName())
				.trophiesNumber(team.getTrophiesNumber())
				.build();
	}

}
