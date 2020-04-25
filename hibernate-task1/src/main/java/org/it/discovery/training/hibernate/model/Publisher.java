package org.it.discovery.training.hibernate.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
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
//@Table
@Entity
@ToString(callSuper = true, exclude = "books")
@DiscriminatorValue("publisher")
public class Publisher extends BaseEntity {

	private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publisher")
	private List<Book> books = new ArrayList<>();

}
