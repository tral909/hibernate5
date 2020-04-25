package org.it.discovery.training.hibernate.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
@ToString(exclude = "books")
public class Publisher {

	private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publisher")
	private List<Book> books = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private LocalDateTime createdAt;

	private LocalDateTime modified;

}
