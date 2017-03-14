package com.fortney.persistance;

import com.fortney.entity.Record;
import com.fortney.persistence.RecordDao;
import org.apache.log4j.Logger;
import org.junit.After ;
import org.junit.Before ;
import org.junit.Test ;

import java.util.List ;

import static org.junit.Assert.* ;


/**
 * Created by Neil on 2/16/2017.
 */
public class AssociationDaoTests {

    private RecordDao dao ;

    /**
     * REFERENCES: http://codesolid.com/a-simple-hibernate-mysql-and-junit-tutorial/
     *             http://www.codejava.net/frameworks/hibernate/hibernate-one-to-one-association-on-primary-key-annotations-example
     *             https://www.mkyong.com/tutorials/hibernate-tutorials/
     */

    @Before
    public void setup() {
        dao = new RecordDao();
    }

    @After
    public void cleanup() {
        // placeholder for now...
    }

    /**
     * Generate list of all user rows
     * @throws Exception
     */
    @Test
    public void getAllRecords() throws Exception {
        List<Record> records = dao.getAllRecords() ;
        Logger log = Logger.getLogger( this.getClass() ) ;
        log.info( "getAllRecords() " + records.size() ) ;
        assertTrue(records.size() > 0 ) ;

        //TODO verify reads from associated tables
        for ( Record rec : records ) {
            log.info( rec.getUrnID().getBrand() +
                    "  " +  rec.getCoffeeID().getCoffeeName() +
                    "  " + rec.getCurrentLocation() ) ;
        }
    }
}
