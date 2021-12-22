package com.ddd.utils;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class MaintainedAutoIdEntity<ID extends Serializable> {

	@Id
	@GeneratedValue
	@Getter
	protected ID id;

	private LocalDateTime insertedDateTime;

	@PrePersist
	private void onCreate() {
		this.insertedDateTime = LocalDateTime.now();
	}

}
