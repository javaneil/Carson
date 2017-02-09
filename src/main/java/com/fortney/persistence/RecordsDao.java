package com.fortney.persistence ;

import com.fortney.entity.Records;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neil on 2/8/2017.
 */
public class RecordsDao {

    private final Logger log = Logger.getLogger( this.getClass() ) ;

    public RecordsDao() {
    }

    /** Return a list of all Records
     *
     * @return All Records
     */
    public List<Records> getAllRecords() {
        List<Records> records = new ArrayList<Records>() ;
        Session session = SessionFactoryProvider.getSessionFactory().openSession() ;
        records = session.createCriteria( Records.class ).list() ;
        return records ;
    }

    /**
     * https://github.com/MadJavaEntSpring2017/week1-user-display-exercise/blob/hibernate-demo/src/main/java/edu/matc/persistence/UserDao.java
     * @param rec
     * @return
     */
    public int createRecord( Records rec ) {
        int id = 0;
        Session session = null;
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


    public Records retrieveRecord( int id ) {
        Records recObj = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession() ;
            recObj = (Records) session.get( Records.class, id ) ;
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


    public void deleteRecord( int id ) {
        log.info( "CoffeeDao.deleteUser( " + id + " )" ) ;

        Session session = null ;
        Transaction transaction = null ;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession() ;
            transaction = session.beginTransaction() ;
            Records recObj = (Records) session.get( Records.class, id ) ;
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
