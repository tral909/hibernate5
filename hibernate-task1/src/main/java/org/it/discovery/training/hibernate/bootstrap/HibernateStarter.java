package org.it.discovery.training.hibernate.bootstrap;

import org.it.discovery.training.hibernate.model.Book;
import org.it.discovery.training.hibernate.model.Publisher;
import org.it.discovery.training.hibernate.repository.BookRepository;
import org.it.discovery.training.hibernate.repository.PublisherRepository;
import org.it.discovery.training.hibernate.repository.hibernate.HibernatePublisherRepository;
import org.it.discovery.training.hibernate.repository.hql.HqlBookRepository;

import java.time.LocalDateTime;

public class HibernateStarter {

    public static void main(String[] args) {
        PublisherRepository repository = new HibernatePublisherRepository();
        Publisher publisher = new Publisher();

        publisher.setName("Packt");
        publisher.setCreated(LocalDateTime.now());

        Book book = new Book();
        book.setName("Hibernate");
        Book book2 = new Book();
        book2.setName("Spring");

        publisher.getBooks().add(book);
        publisher.getBooks().add(book2);

        repository.save(publisher);

        System.out.println(publisher);
        System.out.println(repository.findById(publisher.getId()));

        BookRepository bRep = new HqlBookRepository();

        System.out.println(bRep.findAll());
        System.out.println(bRep.findWithName("SPRING"));
    }

}
