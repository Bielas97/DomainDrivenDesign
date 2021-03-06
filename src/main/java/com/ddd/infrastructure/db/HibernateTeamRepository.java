package com.ddd.infrastructure.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HibernateTeamRepository extends JpaRepository<HibernateTeam, Long> {

}
