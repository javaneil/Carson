package com.fortney.persistance ;

import com.fortney.entity.Coffee;
import com.fortney.entity.Records ;
import com.fortney.entity.Urns;
import com.fortney.persistence.RecordsDao ;
import org.junit.After ;
import org.junit.Before ;
import org.junit.Test ;

import java.time.LocalDate ;
import java.util.List ;

import static org.junit.Assert.* ;

/**
 * Created by Neil on 2/8/2017.
 */
public class RecordsDaoTest {

    RecordsDao dao;

    /**
     * REFERENCE: http://codesolid.com/a-simple-hibernate-mysql-and-junit-tutorial/
     */

    @Before
    public void setup() {
        dao = new RecordsDao();
    }

    @After
    public void cleanup() {
        // placeholder for now...
    }

    /**
     * Generate list of all user rows
     *
     * @throws Exception
     */
    @Test
    public void getAllRecords() throws Exception {
        List<Records> records = dao.getAllRecords() ;
        assertTrue(records.size() > 0);
    }

    @Test
    public void createRecord() throws Exception {
        int id = dao.createRecord( testRecordObj() ) ;
        assertNotEquals( id, 0 ) ;
        if ( 0 < id ) {
            dao.deleteRecord( id ) ;
        }
    }

    @Test
    public void deleteRecord() throws Exception {
        int id = dao.createRecord( testRecordObj() ) ;
        assertNotNull( id ) ;
        dao.deleteRecord( id ) ;
        Records delRec = dao.retrieveRecord( id ) ;
        assertNull( delRec ) ;
    }


    private Records testRecordObj() {
        Records retObj = new Records() ;
        // Foreign Keys are objects
        Urns urnObj = new Urns() ;
        urnObj.setUrnID( 0 ) ;
        Coffee coffeeObj = new Coffee() ;
        coffeeObj.setCoffeeId( 0 ) ;

        retObj.setRecordID( 0 ) ;
        retObj.setUrnID( urnObj ) ; // foreign key
        retObj.setCoffeeID( coffeeObj ) ; // foreign key
        retObj.setCurrentLocation( "Front Counter" ) ;
        retObj.setStartDateTime( "2017-02-05 12:00:00" ) ;
        return retObj;
    }
}