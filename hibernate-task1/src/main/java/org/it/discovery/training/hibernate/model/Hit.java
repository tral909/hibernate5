package org.it.discovery.training.hibernate.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//@Table
@Entity
@Getter @Setter
@DiscriminatorValue("h")
public class Hit extends BaseEntity{
	private String ip;
	
	private String browser;
	
	private LocalDateTime viewed;

	@ManyToOne
	@JoinColumn(name = "BOOK_ID")
	private Book book;

}
