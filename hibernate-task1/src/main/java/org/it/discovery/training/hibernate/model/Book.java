package org.it.discovery.training.hibernate.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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
@ToString(exclude = "hits")
public class Book {

	private String name;

    @ManyToOne
    @JoinColumn(name = "author_id")
	private Person author;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
	private Publisher publisher;
	
	/**
	 * Publishing year
	 */
	private int year;
	
	/**
	 * Total number of pages
	 */
	private int pages;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Hit> hits;

    @Id
    @GeneratedValue(generator = "counter")
    @GenericGenerator(name = "counter", strategy = "org.it.discovery.training.hibernate.generator.CounterGenerator")
	private int id;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime modified;

}
