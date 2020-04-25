package org.it.discovery.training.hibernate.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Book in a library
 * @author morenets
 *
 */
@Table
@Entity
@Getter @Setter
@ToString(exclude = "hits")
public class Book {
	private String name;

	@OneToOne
	private Person author;

	@ManyToOne
	@JoinColumn(name = "PUBLISHER_ID")
	private Publisher publisher;
	
	/**
	 * Publishing year
	 */
	private int year;
	
	/**
	 * Total number of pages
	 */
	private int pages;

	@OneToMany
	private List<Hit> hits;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
