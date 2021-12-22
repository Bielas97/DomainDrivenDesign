package com.ddd.application;

import com.ddd.domain.Team;
import com.ddd.domain.TeamId;
import com.ddd.domain.TeamStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamApplicationService {

	private final TeamStore teamStore;

	public Team addTeam(AddTeamRequest request) {
		// we might use different class for saving the entity because Team object should always have id.
		// in the state of saving the object Team does not have id
		final Team team = Team.builder()
				.name(request.getName())
				// other properties
				.build();
		final TeamId id = teamStore.save(team);
		return teamStore.findById(id)
				.orElseThrow(() -> new RuntimeException("team not found"));
	}

	public void winChampionsLeague(TeamId teamId) {
		final Team team = teamStore.findById(teamId)
				.orElseThrow(() -> new RuntimeException("team not found"));
		team.winChampionsLeague();
		teamStore.update(team);
	}

}
