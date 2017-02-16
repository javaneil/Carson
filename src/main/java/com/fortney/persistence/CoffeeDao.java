package com.fortney.persistence;

import com.fortney.entity.Coffee;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by neilfortney
 */
public class CoffeeDao {

    private final Logger log = Logger.getLogger( this.getClass() ) ;

    /** Return a list of all coffees
     *
     * @return All coffees
     */
    public List<Coffee> getAllCoffees() {
        List<Coffee> coffees = new ArrayList<Coffee>() ;
        Session session = null ;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession() ;
            coffees = session.createCriteria(Coffee.class).list() ;
        }
        catch ( HibernateException hex ) {
            log.error( "HibernateException: ", hex ) ;
        }
        catch ( Exception ex ) {
            log.error( "Exception: ", ex ) ;
        }
        finally {
            if( null != session ) {
                session.close() ;
            }
        }
        return coffees ;
    }

    /**
     * CREATE - add a new coffee row
     *
     * @param coffee - coffee description object
     * @return the id of the inserted record
     *
     * REFERENCE: https://www.tutorialspoint.com/hibernate/hibernate_examples.htm
     */
    public int addCoffee( Coffee coffee ) {
        log.info( "CoffeeDao.addCoffee( " + coffee + " )" ) ;
        int id = 0 ;
        Session session = null ;
        Transaction transaction = null ;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession() ;
            transaction = session.beginTransaction() ;
            id = (int) session.save( coffee ) ;
            transaction.commit() ;
        }
        catch ( HibernateException hex ) {
            log.error( "Session.save fail:  ", hex ) ;
            if ( null != transaction ) {
                transaction.rollback() ;
            }
        }
        finally {
            if( null != session ) {
                session.close();
            }
        }
        return id ;
    }

    /**
     * RETRIEVE - retrieve a coffee row given its id
     *
     * @param id the coffee's id
     * @return coffee object
     */
    public Coffee getCoffee( int id ) {
        log.info( "CoffeeDao.getCoffee( " + id + " )" ) ;
        Coffee coffee = null ;
        Session session = null ;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession() ;
            coffee = (Coffee) session.get( Coffee.class, id ) ;
        }
        catch ( HibernateException hex ) {
            log.error( "Session.save fail:  ", hex ) ;
        }
        finally {
            if( null != session ) {
                session.close();
            }
        }
        return coffee ;
    }

    /**
     * UPDATE - Change existing coffee row
     * @param coffee - coffee description object
     */
    public void updateCoffee( Coffee coffee) {
        log.info( "CoffeeDao.updateUser( " + coffee + " )" ) ;
        Session session = null ;
        Transaction transaction = null ;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession() ;
            transaction = session.beginTransaction() ;
            session.update(coffee) ;
            transaction.commit() ;
        }
        catch ( HibernateException hex ) {
            log.error( "Session.save fail:  ", hex ) ;
            if ( null != transaction ) {
                transaction.rollback() ;
            }
        }
        finally {
            if( null != session ) {
                session.close();
            }
        }
    }

    /**
     * DELETE - remove a coffee row by id
     * @param id the coffee's id
     *
     * REFERENCE: https://www.tutorialspoint.com/hibernate/hibernate_examples.htm
     */
    public void deleteCoffee( int id ) {
        log.info( "CoffeeDao.deleteUser( " + id + " )" ) ;
        Session session = null ;
        Transaction transaction = null ;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession() ;
            transaction = session.beginTransaction() ;
            Coffee coffee = (Coffee) session.get( Coffee.class, id ) ;
            session.delete(coffee) ;
            transaction.commit() ;
        }
        catch ( HibernateException hex ) {
            log.error( "Session.delete fail:  ", hex ) ;
            if ( null != transaction ) {
                transaction.rollback() ;
            }
        }
        finally {
            if( null != session ) {
                session.close();
            }
        }
    }
}
