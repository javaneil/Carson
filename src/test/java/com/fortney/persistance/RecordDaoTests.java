package com.fortney.persistance ;

import com.fortney.entity.Record;
import com.fortney.persistence.RecordDao;
import org.junit.After ;
import org.junit.Before ;
import org.junit.Test ;

import java.util.List ;

import static org.junit.Assert.* ;

/**
 * Created by Neil on 2/8/2017.
 */
public class RecordDaoTests {

    private RecordDao dao;

    /**
     * REFERENCE: http://codesolid.com/a-simple-hibernate-mysql-and-junit-tutorial/
     */

    @Before
    public void setup() {
        dao = new RecordDao() ;
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
        List<Record> records = dao.getAllRecords() ;
        assertTrue(records.size() > 0 ) ;
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
    public void updateRecord() throws Exception {
        Record rec = testRecordObj() ;
        int id = dao.createRecord( rec ) ;
        rec.setCurrentLocation( "Back Counter" ) ; ;
        dao.updateRecord( rec ) ;
        Record updRecord = dao.retrieveRecord( id ) ;
        assertEquals( updRecord.getCurrentLocation(), "Back Counter" ) ;
        if ( (null != updRecord) && (0 < id) ) {
            dao.deleteRecord( id ) ;
        }

    }

    @Test
    public void deleteRecord() throws Exception {
        int id = dao.createRecord( testRecordObj() ) ;
        assertNotNull( id ) ;
        dao.deleteRecord( id ) ;
        Record delRec = dao.retrieveRecord( id ) ;
        assertNull( delRec ) ;
    }


    private Record testRecordObj() {
        Record retObj = new Record("Front Counter", "2017-02-05 12:00:00" ) ;
        return retObj;
    }
}