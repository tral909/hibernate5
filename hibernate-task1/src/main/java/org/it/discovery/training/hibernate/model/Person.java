package org.it.discovery.training.hibernate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
public class Person extends BaseEntity {
	private String name;
	
	/** Books that person has written */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "author", orphanRemoval = true)
	private List<Book> books;

}
