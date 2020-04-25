package org.it.discovery.training.hibernate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDateTime;

@Getter
@Setter
@Table
@Entity
public class Hit {
	private String ip;
	
	private String browser;
	
	private LocalDateTime viewed;
    @Transient
	private Book book;
	@Id
	private int id;
	
	private LocalDateTime created;
	
	private LocalDateTime modified;
	
	public Book getBook() {
		return book;
	}

}
