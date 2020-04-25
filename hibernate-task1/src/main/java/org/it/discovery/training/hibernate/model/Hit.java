package org.it.discovery.training.hibernate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Table
@Entity
public class Hit {

	private String ip;
	
	private String browser;
	
	private LocalDateTime viewed;

	@ManyToOne
	private Book book;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	private LocalDateTime created;
	
	private LocalDateTime modified;

}
