package com.fortney.persistance;

import com.fortney.entity.Coffee;
import com.fortney.persistence.CoffeeDao;
import static com.fortney.util.TestCommon.testCoffeeObj1;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import static org.junit.Assert.*;


/**
 * Created on 2017_02_07
 *
 * @author Neil Fortney
 */
public class CoffeeDaoTests {

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
        List<Coffee> coffees = dao.retrieveAllCoffees() ;
        assertNotNull( coffees ) ;
        assertTrue( 0 < coffees.size() ) ;
    }

    /**
     * "C" is for Create
     * @throws Exception
     */
    @Test
    public void addCoffee() throws Exception {
        int size = dao.retrieveAllCoffees().size() ;
        int id = dao.createCoffee( testCoffeeObj1() ) ;
        assertEquals( size + 1, dao.retrieveAllCoffees().size() ) ;
        assertTrue( 0 < id ) ;
        dao.deleteCoffee( id ) ;
        assertEquals( size, dao.retrieveAllCoffees().size() ) ;
    }

    /**
     * "R" is for Retrieve
     * @throws Exception
     */
    @Test
    public void getCoffee() throws Exception {
        int size = dao.retrieveAllCoffees().size() ;
        int id = dao.createCoffee( testCoffeeObj1() ) ;
        assertTrue( 0 < id ) ;
        Coffee retCoffee = dao.retrieveCoffee( id ) ;
        assertNotNull( retCoffee ) ;
        assertEquals( id, retCoffee.getCoffeeId() ) ;
        dao.deleteCoffee( id ) ;
        assertEquals( size, dao.retrieveAllCoffees().size() ) ;
    }

    /**
     * "U" is for Update
     * @throws Exception
     */
    @Test
    public void updateCoffee() throws Exception {
        int size = dao.retrieveAllCoffees().size() ;
        Coffee coffee = testCoffeeObj1() ;
        int id = dao.createCoffee( coffee ) ;
        assertTrue( 0 < id ) ;
        assertEquals( size + 1, dao.retrieveAllCoffees().size() ) ;
        coffee.setCoffeeName( "Mocha Mud" ) ;
        assertTrue( dao.updateCoffee( coffee ) ) ;
        Coffee updCoffee = dao.retrieveCoffee( id ) ;
        assertEquals( "Mocha Mud", updCoffee.getCoffeeName() ) ;
        dao.deleteCoffee( id ) ;
        assertEquals( size, dao.retrieveAllCoffees().size() ) ;
    }

    /**
     * "D" is for Delete
     * @throws Exception
     */
    @Test
    public void deleteCoffee() throws Exception {
        int size = dao.retrieveAllCoffees().size() ;
        int id = dao.createCoffee( testCoffeeObj1() ) ;
        assertTrue( 0 < id ) ;
        assertEquals( size + 1, dao.retrieveAllCoffees().size() ) ;
        dao.deleteCoffee( id ) ;
        Coffee delCoffee = dao.retrieveCoffee( id ) ;
        assertNull( delCoffee ) ;
        assertEquals( size, dao.retrieveAllCoffees().size() ) ;
    }

}