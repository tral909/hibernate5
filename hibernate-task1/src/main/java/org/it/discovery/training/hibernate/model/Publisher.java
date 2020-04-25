package org.it.discovery.training.hibernate.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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
@ToString
public class Publisher {
	private String name;

	@Transient
	private List<Book> books;

	@Id
	@GeneratedValue(generator = "counter")
	@GenericGenerator(name = "counter", strategy = "org.it.discovery.training.hibernate.generator.CounterGenerator")
	private int id;

	private LocalDateTime createdAt;

	private LocalDateTime modified;

	public List<Book> getBooks() {
		return books;
	}
}
