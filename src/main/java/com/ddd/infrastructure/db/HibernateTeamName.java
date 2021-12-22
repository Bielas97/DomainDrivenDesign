package com.ddd.infrastructure.db;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HibernateTeamName {

	private String shortName;

	private String fullName;

}
