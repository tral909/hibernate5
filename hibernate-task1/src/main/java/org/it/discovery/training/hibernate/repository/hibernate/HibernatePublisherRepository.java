package org.it.discovery.training.hibernate.repository.hibernate;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.it.discovery.training.hibernate.model.Publisher;
import org.it.discovery.training.hibernate.repository.PublisherRepository;

import java.util.List;

@RequiredArgsConstructor
public class HibernatePublisherRepository implements PublisherRepository {
    private final SessionFactory sessionFactory;

    @Override
    public void save(Publisher publisher) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.save(publisher);
            session.close();
        } catch (Exception ex) {
            if(session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        }
    }

    @Override
    //TODO implement
    public void saveAll(List<Publisher> publishers) {

    }

    @Override
    //TODO implement
    public void delete(int publisherId) {

    }

    @Override
    public Publisher findById(int publisherId) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Publisher publisher = session.get(Publisher.class, publisherId);
            session.close();
            return publisher;
        } catch (Exception ex) {
            if(session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        }
    }
}
