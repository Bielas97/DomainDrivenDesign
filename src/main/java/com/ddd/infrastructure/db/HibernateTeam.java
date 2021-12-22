package com.ddd.infrastructure.db;

import com.ddd.utils.MaintainedAutoIdEntity;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HibernateTeam extends MaintainedAutoIdEntity<Long> {

	@Embedded
	private HibernateTeamName name;

	private Integer trophiesNumber;

}
