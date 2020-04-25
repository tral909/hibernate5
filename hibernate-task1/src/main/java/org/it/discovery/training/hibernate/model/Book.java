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
 * Book in a library
 * @author morenets
 *
 */
@Table
@Entity
@Getter @Setter
public class Book {
	private String name;

	@Transient
	private Person author;

	@Transient
	private Publisher publisher;
	
	/**
	 * Publishing year
	 */
	private int year;
	
	/**
	 * Total number of pages
	 */
	private int pages;

	@Transient
	private List<Hit> hits;

	@Id
	private int id;
	
	private LocalDateTime created;
	
	private LocalDateTime modified;

	public Person getAuthor() {
		return author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public List<Hit> getHits() {
		return hits;
	}
}
