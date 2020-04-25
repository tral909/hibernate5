package org.it.discovery.training.hibernate.repository.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.it.discovery.training.hibernate.model.Book;
import org.it.discovery.training.hibernate.repository.BookRepository;
import org.it.discovery.training.hibernate.util.HibernateUtil;

import java.util.List;

public class HqlBookRepository implements BookRepository {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Book> findAll() {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Query<Book> query = session.createQuery("from Book");
            List<Book> list = query.list();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Book> findWithName(String name) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Query<Book> query = session.createQuery("from Book b where lower(b.name) LIKE :name")
                    .setParameter("name", name.toLowerCase());
            List<Book> list = query.list();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Book> findWithHits() {
        return null;
    }

    @Override
    public List<Book> findWithMorePages(int pages) {
        return null;
    }

    @Override
    public List<Book> searchBooks(String name, int pages) {
        return null;
    }

    @Override
    public int findTotalPages() {
        return 0;
    }

    @Override
    public List<Book> findSortedBooks() {
        return null;
    }
}
