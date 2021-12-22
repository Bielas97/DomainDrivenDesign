package com.ddd.infrastructure;

import com.ddd.domain.Team;
import com.ddd.domain.TeamId;
import com.ddd.domain.TeamName;
import com.ddd.domain.TeamStore;
import com.ddd.infrastructure.db.HibernateTeam;
import com.ddd.infrastructure.db.HibernateTeamName;
import com.ddd.infrastructure.db.HibernateTeamRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TeamRepository implements TeamStore {

	private final HibernateTeamRepository hRepository;

	@Override
	public Optional<Team> findById(TeamId teamId) {
		return hRepository.findById(teamId.getInternal())
				.map(hTeam -> {
					final TeamName teamName = new TeamName(hTeam.getName().getShortName(), hTeam.getName().getFullName());
					return Team.builder()
							.teamId(TeamId.valueOf(hTeam.getId()))
							.name(teamName)
							.trophiesNumber(hTeam.getTrophiesNumber())
							.build();
				});
	}

	@Override
	public TeamId save(Team team) {
		final HibernateTeamName hTeamName = new HibernateTeamName(team.getName().getShortName(), team.getName().getFullName());
		final HibernateTeam hibernateTeam = new HibernateTeam(hTeamName, team.getTrophiesNumber());
		final HibernateTeam saved = hRepository.save(hibernateTeam);
		return TeamId.valueOf(saved.getId());
	}

	@Override
	public TeamId update(Team team) {
		final HibernateTeam hTeam = hRepository.findById(team.getTeamId().getInternal())
				.orElseThrow(() -> new RuntimeException("Team not found"));
		final HibernateTeamName hTeamName = new HibernateTeamName(team.getName().getShortName(), team.getName().getFullName());
		hTeam.setName(hTeamName);
		hTeam.setTrophiesNumber(team.getTrophiesNumber());
		final HibernateTeam saved = hRepository.save(hTeam);
		return TeamId.valueOf(saved.getId());
	}
}
