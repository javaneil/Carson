package com.fortney.persistance;

import com.fortney.entity.Coffee;
import com.fortney.persistence.CoffeeDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;


/**
 * Created on 2017_02_07
 *
 * @author Neil Fortney
 */
public class CoffeeDaoTest {

    private CoffeeDao dao ;

    /**
     * FURTHER REFERENCE: http://codesolid.com/a-simple-hibernate-mysql-and-junit-tutorial/
     */

    @Before
    public void setup() {
        dao = new CoffeeDao() ;
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
    public void getAllCoffees() throws Exception {
        List<Coffee> coffees = dao.getAllCoffees() ;
        assertTrue(coffees.size() > 0 ) ;
    }

    /**
     * "C" is for Create
     * @throws Exception
     */
    @Test
    public void addCoffee() throws Exception {
        int id = dao.addCoffee( testCoffeeObj() ) ;
        assertNotEquals( id, 0 ) ;
        if ( 0 < id ) {
            dao.deleteCoffee( id ) ;
        }
    }

    /**
     * "R" is for Retrieve
     * @throws Exception
     */
    @Test
    public void getUser() throws Exception {
        int id = dao.addCoffee( testCoffeeObj() ) ;
        Coffee retCoffee = dao.getCoffee( id ) ;
        assertNotNull( retCoffee ) ;
        assertEquals( retCoffee.getCoffeeId(), id ) ;
        if ( (null != retCoffee) && (0 < id) ) {
            dao.deleteCoffee( id ) ;
        }
    }

    /**
     * "U" is for Update
     * @throws Exception
     */
    @Test
    public void updateUser() throws Exception {
        Coffee coffee = testCoffeeObj() ;
        int id = dao.addCoffee( coffee ) ;
        coffee.setCoffeeName( "Mocha Mud" ); ;
        dao.updateCoffee( coffee ) ;
        Coffee updCoffee = dao.getCoffee( id ) ;
        assertEquals( updCoffee.getCoffeeName(), "Mocha Mud" ) ;
        if ( (null != updCoffee) && (0 < id) ) {
            dao.deleteCoffee( id ) ;
        }
    }

    /**
     * "D" is for Delete
     * @throws Exception
     */
    @Test
    public void deleteCoffee() throws Exception {
        int id = dao.addCoffee( testCoffeeObj() ) ;
        dao.deleteCoffee( id ) ;
        Coffee delUser = dao.getCoffee( id ) ;
        assertNull( delUser ) ;
    }

    /**
     * Utilities
     */
    private Coffee testCoffeeObj() {
        Coffee retObj = new Coffee("Yuckban", "A truely disgusting cup of mud",
                "Queequegs", "123 Oak Street", "Seattle", "WA", "98101",
                "1 800 555 1212" ) ;
        return retObj;
    }

    private LocalDate testDate () {
        LocalDate retDate = LocalDate.parse( "1956-12-31" ) ;
        return retDate ;
    }

}