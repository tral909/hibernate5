package org.it.discovery.training.hibernate.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Book in a library
 * @author morenets
 *
 */
@Getter
@Setter
//@Table
@Entity
@ToString(exclude = "hits")
@DiscriminatorValue("book")
public class Book extends BaseEntity {

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

}
