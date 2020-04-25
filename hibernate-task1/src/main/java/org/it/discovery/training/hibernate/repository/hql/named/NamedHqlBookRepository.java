package org.it.discovery.training.hibernate.repository.hql.named;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.it.discovery.training.hibernate.model.Book;
import org.it.discovery.training.hibernate.repository.BookRepository;

import java.util.List;

@RequiredArgsConstructor
public class NamedHqlBookRepository implements BookRepository {
    private final SessionFactory sessionFactory;

    @Override
    public List<Book> findAll() {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Query<Book> query = session.getNamedQuery(Book.QUERY_FIND_ALL);
            List<Book> books = query.list();
            session.getTransaction().commit();
            return books;
        } catch (Exception ex) {
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Book> findWithName(String name) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Query<Book> query = session.createNamedQuery(Book.QUERY_FIND_BY_NAME, Book.class);
            query.setParameter("name", name);
            List<Book> books = query.list();
            session.getTransaction().commit();
            return books;
        } catch (Exception ex) {
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
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
