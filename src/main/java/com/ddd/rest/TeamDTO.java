package com.ddd.rest;

import lombok.Builder;

@Builder
public class TeamDTO {

	public long id;

	public String shortName;

	public String fullName;

	public int trophiesNumber;

}
