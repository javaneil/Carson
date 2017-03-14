package com.fortney.persistence ;

import com.fortney.entity.Record;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neil on 2/8/2017.
 */
public class RecordDao {

    private final Logger log = Logger.getLogger( this.getClass() ) ;


    /** Return a list of all Record
     *
     * @return All Record
     */
    public List<Record> getAllRecords() {
        List<Record> records = new ArrayList<Record>() ;
        Session session = null ;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            records = session.createCriteria(Record.class).list();
        }
        catch ( HibernateException hex ) {
            log.error( "Hibernate Exception: " + hex ) ;
        }
        catch ( Exception ex ) {
            log.error( "Exception: " + ex ) ;
        }
        if ( session != null ) {
            session.close() ;
        }
        return records ;
    }

    /**
     * https://github.com/MadJavaEntSpring2017/week1-user-display-exercise/blob/hibernate-demo/src/main/java/edu/matc/persistence/UserDao.java
     * @param rec - records object to commit
     * @return - unique ID assigned by database
     */
    public int createRecord( Record rec ) {
        int id = 0 ;
        Session session = null ;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession() ;
            Transaction transaction = session.beginTransaction() ;
            id = (int) session.save( rec ) ;
            transaction.commit() ;
        } catch ( HibernateException hex ) {
            log.error( "Exception: " + hex ) ;
        } catch ( Exception ex ) {
            log.error( "Exception: " + ex.getMessage() ) ;
        } finally {
            if ( session != null ) {
                session.close() ;
            }
        }
        return id;
    }


    public Record retrieveRecord(int id ) {
        Record recObj = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession() ;
            recObj = (Record) session.get( Record.class, id ) ;
        } catch ( HibernateException hex ) {
            log.error( "Exception: " + hex ) ;
        } catch ( Exception ex ) {
            log.error( "Exception: " + ex.getMessage() ) ;
        } finally {
            if ( session != null ) {
                session.close() ;
            }
        }
        return recObj ;
    }


    public void updateRecord( Record record ) {
        Session session = null ;
        Transaction transaction = null ;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession() ;
            transaction = session.beginTransaction() ;
            session.update( record ) ;
            transaction.commit() ;
        }
        catch ( HibernateException hex ) {
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


    public void deleteRecord( int id ) {
        log.info( "CoffeeDao.deleteUser( " + id + " )" ) ;
        Session session = null ;
        Transaction transaction = null ;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession() ;
            transaction = session.beginTransaction() ;
            Record recObj = (Record) session.get( Record.class, id ) ;
            session.delete( recObj ) ;
            transaction.commit() ;
        }
        catch ( HibernateException hex ) {
            log.error( "Session.delete fail:  ", hex ) ;
            if ( null != transaction ) {
                transaction.rollback() ;
            }
        }
        finally {
            if ( session != null ) {
                session.close() ;
            }
        }
    }
}
