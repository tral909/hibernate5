package org.it.discovery.training.hibernate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Table
@Entity
public class Hit extends BaseEntity {

	private String ip;
	
	private String browser;
	
	private LocalDateTime viewed;

	@ManyToOne
	private Book book;

}
