package org.it.discovery.training.hibernate.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.it.discovery.training.hibernate.model.Publisher;
import org.it.discovery.training.hibernate.util.HibernateUtil;

import java.util.List;

public class HibernatePublisherRepository implements PublisherRepository {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void save(Publisher publisher) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.save(publisher);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
        }
    }

    @Override
    public void saveAll(List<Publisher> publishers) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            for (Publisher p : publishers) {
                session.save(p);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
        }
    }

    @Override
    public void delete(int publisherId) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Publisher publisher = session.find(Publisher.class, publisherId);
            if (publisher != null) {
                session.delete(publisher);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
        }
    }

    @Override
    public Publisher findById(int publisherId) {
        Session session = null;
        Publisher result = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            result = session.find(Publisher.class, publisherId);
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
            throw new RuntimeException(e);
        }
    }

}
