package org.it.discovery.training.hibernate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Book publisher
 * 
 * @author morenets
 *
 */
@Getter
@Setter
@Table
@Entity
public class Publisher {
	private String name;
    @Transient
	private List<Book> books;
    @Id
	private int id;

	private LocalDateTime created;

	private LocalDateTime modified;

	public List<Book> getBooks() {
		return books;
	}
}
