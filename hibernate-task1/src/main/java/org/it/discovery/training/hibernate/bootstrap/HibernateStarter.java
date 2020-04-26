package org.it.discovery.training.hibernate.bootstrap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.it.discovery.training.hibernate.model.Book;
import org.it.discovery.training.hibernate.model.Hit;
import org.it.discovery.training.hibernate.model.Publisher;
import org.it.discovery.training.hibernate.repository.BookRepository;
import org.it.discovery.training.hibernate.repository.PublisherRepository;
import org.it.discovery.training.hibernate.repository.hibernate.HibernatePublisherRepository;
import org.it.discovery.training.hibernate.repository.hql.HqlBookRepository;
import org.it.discovery.training.hibernate.repository.hql.named.NamedHqlBookRepository;
import org.it.discovery.training.hibernate.util.HibernateUtil;

import java.time.LocalDateTime;

public class HibernateStarter {

	public static void main(String[] args) {
		Session session = null;
		try (SessionFactory factory = HibernateUtil.getSessionFactory()) {

			PublisherRepository repository = new HibernatePublisherRepository(factory);
			Publisher publisher = new Publisher();
			publisher.setName("Packt");
			publisher.setCreated(LocalDateTime.now());

			Book book = new Book();
			book.setName("Hibernate");
			publisher.addBook(book);

			Hit hit = new Hit();
			hit.setViewed(LocalDateTime.now());
			hit.setBrowser("Chrome");
			hit.setIp("localhost");
			book.addHit(hit);
			repository.save(publisher);

			System.out.println(publisher);

			System.out.println("--- Querying from cache");
			System.out.println(repository.findById(publisher.getId()));
			System.out.println(repository.findById(publisher.getId()));
			System.out.println(repository.findById(publisher.getId()));

			System.out.println("--- end querying from cache");
			BookRepository bookRepository = new HqlBookRepository(factory);
			System.out.println("--- Querying from cache");
			System.out.println("All books: " + bookRepository.findAll());
			System.out.println("All books: " + bookRepository.findAll());
			System.out.println("All books: " + bookRepository.findAll());
			System.out.println("--- end querying from cache");
			System.out.println("Books with name MySQL: " + bookRepository.findWithName("MySQL"));

			BookRepository namedBookRepository = new NamedHqlBookRepository(factory);
			System.out.println("All books: " + namedBookRepository.findAll());
			System.out.println("Books with name MySQL: " + namedBookRepository.findWithName("MySQL"));

			System.out.println("Book info = " + bookRepository.findBookInfo(book.getId())); //1000

		} catch (Exception ex) {
			ex.printStackTrace();
			if (session != null) {
				session.getTransaction().rollback();
			}
		}

	}

}
