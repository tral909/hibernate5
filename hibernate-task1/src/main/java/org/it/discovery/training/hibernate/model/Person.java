package org.it.discovery.training.hibernate.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Person who can write books, for example
 * @author admin
 *
 */
@Table
@Entity
@Getter @Setter
public class Person extends BaseEntity{
	private String name;
	
	/**
	 * Books that person has written
	 */
	@OneToMany(mappedBy = "author")
	private List<Book> books;

}
