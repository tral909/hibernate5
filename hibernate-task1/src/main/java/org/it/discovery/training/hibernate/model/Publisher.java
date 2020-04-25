package org.it.discovery.training.hibernate.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Book publisher
 * 
 * @author morenets
 *
 */
@Getter
@Setter
public class Publisher {
	private String name;

	private List<Book> books;

	private int id;

	private LocalDateTime created;

	private LocalDateTime modified;

	public List<Book> getBooks() {
		return books;
	}
}
