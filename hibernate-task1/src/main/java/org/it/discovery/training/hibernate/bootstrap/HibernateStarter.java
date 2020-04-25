package org.it.discovery.training.hibernate.bootstrap;

import org.it.discovery.training.hibernate.model.Book;
import org.it.discovery.training.hibernate.model.Publisher;
import org.it.discovery.training.hibernate.repository.HibernatePublisherRepository;
import org.it.discovery.training.hibernate.repository.PublisherRepository;

import java.time.LocalDateTime;

public class HibernateStarter {

    public static void main(String[] args) {
        PublisherRepository repository = new HibernatePublisherRepository();
        Publisher publisher = new Publisher();

        publisher.setName("Packt");
        publisher.setCreatedAt(LocalDateTime.now());

        Book book = new Book();
        book.setName("Hibernate");
        publisher.getBooks().add(book);

        repository.save(publisher);

        System.out.println(publisher);
        System.out.println(repository.findById(publisher.getId()));
    }

}
