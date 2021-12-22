package com.ddd.domain;

import com.ddd.utils.SimpleId;

public class TeamId extends SimpleId<Long> {

	private TeamId(Long internal) {
		super(internal);
	}

	public static TeamId valueOf(long id) {
		//some extra validation if needed
		return new TeamId(id);
	}
}
