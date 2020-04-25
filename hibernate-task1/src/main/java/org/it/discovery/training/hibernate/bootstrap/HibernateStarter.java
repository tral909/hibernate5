package org.it.discovery.training.hibernate.bootstrap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.it.discovery.training.hibernate.model.Book;
import org.it.discovery.training.hibernate.model.Publisher;
import org.it.discovery.training.hibernate.repository.PublisherRepository;
import org.it.discovery.training.hibernate.repository.hibernate.HibernatePublisherRepository;
import org.it.discovery.training.hibernate.util.HibernateUtil;

import java.time.LocalDateTime;

public class HibernateStarter {

	public static void main(String[] args) {
		Session session = null;
		try (SessionFactory factory = HibernateUtil.getSessionFactory()) {

			PublisherRepository repository = new HibernatePublisherRepository(factory);
			Publisher publisher = new Publisher();
			publisher.setName("Packt");
			publisher.setCreatedAt(LocalDateTime.now());

			Book book = new Book();
			book.setName("Hibernate");
			publisher.addBook(book);
			repository.save(publisher);

			System.out.println(publisher);

			System.out.println(repository.findById(publisher.getId()));


		} catch (Exception ex) {
			ex.printStackTrace();
			if (session != null) {
				session.getTransaction().rollback();
			}
		}

	}

}
