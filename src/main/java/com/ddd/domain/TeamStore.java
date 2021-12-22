package com.ddd.domain;

import java.util.Optional;

public interface TeamStore {

	Optional<Team> findById(TeamId teamId);

	TeamId save(Team team);

	TeamId update(Team team);
}
