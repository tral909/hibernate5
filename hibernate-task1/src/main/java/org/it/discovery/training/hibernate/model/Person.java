package org.it.discovery.training.hibernate.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Person who can write books, for example
 * @author admin
 *
 */
@Table
@Entity
@Getter @Setter
public class Person {
	private String name;
	
	/**
	 * Books that person has written
	 */
	@Transient
	private List<Book> books;

	@Id
	private int id;
	
	private LocalDateTime created;
	
	private LocalDateTime modified;

	public List<Book> getBooks() {
		return books;
	}
}
