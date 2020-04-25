package org.it.discovery.training.hibernate.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
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

	public void addBook(Book book){
		if(books == null){
			books= new ArrayList<>();
		}
		books.add(book);
	}
}
