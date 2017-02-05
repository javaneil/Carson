package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by paulawaite on 2/2/16.
 */
public class UserDao {

    private final Logger log = Logger.getLogger( this.getClass() ) ;

    /** Return a list of all users
     *
     * @return All users
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>() ;
        Session session = SessionFactoryProvider.getSessionFactory().openSession() ;
        users = session.createCriteria(User.class).list() ;
        return users ;
    }

    /**
     * CREATE - add a new user row
     *
     * @param user
     * @return the id of the inserted record
     *
     * REFERENCE: https://www.tutorialspoint.com/hibernate/hibernate_examples.htm
     */
    public int addUser( User user ) {
        log.info( "UserDao.addUser( " + user + " )" ) ;
        int id = 0 ;

        Session session = SessionFactoryProvider.getSessionFactory().openSession() ;
        Transaction transaction = null ;
        try {
            transaction = session.beginTransaction() ;
            id = (int) session.save( user ) ;
            transaction.commit() ;
        }
        catch ( HibernateException hex ) {
            log.error( "Session.save fail:  ", hex ) ;
            if ( null != transaction ) {
                transaction.rollback() ;
            }
        }
        finally {
            session.close() ;
        }
        return id ;
    }

    /**
     * RETRIEVE - retrieve a user row given its id
     *
     * @param id the user's id
     * @return user
     */
    public User getUser( int id ) {
        log.info( "UserDao.getUser( " + id + " )" ) ;
        User user = null ;

        Session session = SessionFactoryProvider.getSessionFactory().openSession() ;
        try {
            user = (User) session.get( User.class, id ) ;
        }
        catch ( HibernateException hex ) {
            log.error( "Session.save fail:  ", hex ) ;
        }
        finally {
            session.close() ;
        }
        return user ;
    }

    /**
     * UPDATE - Change existing user row
     * @param user
     */
    public void updateUser( User user ) {
        log.info( "UserDao.updateUser( " + user + " )" ) ;

        Session session = SessionFactoryProvider.getSessionFactory().openSession() ;
        Transaction transaction = null ;
        try {
            transaction = session.beginTransaction() ;
            session.update( user ) ;
            transaction.commit() ;
        }
        catch ( HibernateException hex ) {
            log.error( "Session.save fail:  ", hex ) ;
            if ( null != transaction ) {
                transaction.rollback() ;
            }
        }
        finally {
            session.close() ;
        }
    }

    /**
     * DELETE - remove a user row by id
     * @param id the user's id
     *
     * REFERENCE: https://www.tutorialspoint.com/hibernate/hibernate_examples.htm
     */
    public void deleteUser( int id ) {
        log.info( "UserDao.deleteUser( " + id + " )" ) ;

        Session session = SessionFactoryProvider.getSessionFactory().openSession() ;
        Transaction transaction = null ;
        try {
            transaction = session.beginTransaction() ;
            User user = (User) session.get( User.class, id ) ;
            session.delete( user ) ;
            transaction.commit() ;
        }
        catch ( HibernateException hex ) {
            log.error( "Session.delete fail:  ", hex ) ;
            if ( null != transaction ) {
                transaction.rollback() ;
            }
        }
        finally {
            session.close() ;
        }
    }
}
