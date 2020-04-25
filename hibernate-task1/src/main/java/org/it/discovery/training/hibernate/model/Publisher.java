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
//@Table
@Entity
@ToString
@DiscriminatorValue("r")
public class Publisher extends BaseEntity {
	private String name;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "publisher")
	private List<Book> books;

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
