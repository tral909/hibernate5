package org.it.discovery.training.hibernate.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Book in a library
 *
 * @author morenets
 */
@Table
@Entity
@Getter
@Setter
@ToString(exclude = "hits")
@NamedQuery(name = Book.QUERY_FIND_ALL, query = "FROM Book")
@NamedQuery(name = Book.QUERY_FIND_BY_NAME, query = "FROM Book WHERE name=:name")
public class Book extends BaseEntity {
    public static final String QUERY_FIND_ALL = "Book.findAll";

    public static final String QUERY_FIND_BY_NAME = "Book.findByName";

    private String name;

    @OneToOne
    private Person author;

    @ManyToOne
    @JoinColumn(name = "PUBLISHER_ID")
    private Publisher publisher;

    /**
     * Publishing year
     */
    private int year;

    /**
     * Total number of pages
     */
    private int pages;

    @OneToMany(mappedBy = "book")
    private List<Hit> hits;
}
