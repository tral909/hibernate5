package org.it.discovery.training.hibernate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Person who can write books, for example
 * @author admin
 *
 */
@Getter
@Setter
@Table
@Entity
public class Person {
	private String name;
	
	/** Books that person has written */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "author", orphanRemoval = true)
	private List<Book> books;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	private LocalDateTime created;
	
	private LocalDateTime modified;

}
