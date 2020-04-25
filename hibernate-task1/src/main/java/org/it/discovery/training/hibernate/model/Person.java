package org.it.discovery.training.hibernate.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Person who can write books, for example
 * @author admin
 *
 */
@Getter @Setter
public class Person {
	private String name;
	
	/**
	 * Books that person has written
	 */
	private List<Book> books;
	
	private int id;
	
	private LocalDateTime created;
	
	private LocalDateTime modified;

	public List<Book> getBooks() {
		return books;
	}
}
