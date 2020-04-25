package org.it.discovery.training.hibernate.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Book in a library
 * @author morenets
 *
 */
@Getter
@Setter
@Table
@Entity
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
    @GeneratedValue(generator = "counter")
    @GenericGenerator(name = "counter", strategy = "org.it.discovery.training.hibernate.generator.CounterGenerator")
	private int id;
	
	private LocalDateTime createdAt;
	
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
