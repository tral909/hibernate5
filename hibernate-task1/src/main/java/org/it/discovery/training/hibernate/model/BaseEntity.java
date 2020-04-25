package org.it.discovery.training.hibernate.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@MappedSuperclass
public abstract class BaseEntity {
	@Id
	@GeneratedValue
	private int id;
	
	private LocalDateTime created;
	
	private LocalDateTime modified;

}
