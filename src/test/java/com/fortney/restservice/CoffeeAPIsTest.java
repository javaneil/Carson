package com.fortney.restservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fortney.entity.Coffee;
import com.fortney.persistence.CoffeeDao;
import com.fortney.roboPojoGen.*;
import com.fortney.roboPojoGen.CoffeeJson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

import static com.fortney.util.TestCommon.testCoffeeObj1;
import static com.fortney.util.TestCommon.testCoffeeObj2;
import static org.junit.Assert.*;

/**
 * This test suite validates the Producer web services for the Coffee Entity
 * NOTE: Dependent on CoffeeDaoTests suite executing successfully
 * References:
 *      http://codesolid.com/a-simple-hibernate-mysql-and-junit-tutorial/
 * Created by Neil on 3/15/2017.
 */
public class CoffeeAPIsTest {

    private CoffeeDao dao ;

    @Before
    public void setUp() throws Exception {
        dao = new CoffeeDao() ;
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getHtmlAll() throws Exception {

    }

    @Test
    public void getHtmlById() throws Exception {

    }

    /**
     * Get current Coffee list size locally, then compare with list retrieved from web services.
     * @throws Exception
     */
    @Test
    public void getJsonAll() throws Exception {
        int size = dao.retrieveAllCoffees().size() ;
        Client client = ClientBuilder.newClient() ;
        WebTarget target = client.target( "http://localhost:8080/CarsonTCB/api/coffees/json" ) ;

        Invocation.Builder builder = target.request( MediaType.APPLICATION_JSON ) ;
        String response = builder.get( String.class ) ;

        ObjectMapper mapper = new ObjectMapper() ;
        com.fortney.roboPojoGen.CoffeeJson results = mapper.readValue( response, com.fortney.roboPojoGen.CoffeeJson.class ) ;

        assertTrue( size == results.getCoffeeJson().size() ) ;
    }

    /**
     * Add a new Coffee type to list locally, then confirm it has been persisted
     * using web services
     * @throws Exception
     */
    @Test
    public void getJsonById() throws Exception {
        int size = dao.retrieveAllCoffees().size() ;
        int id = dao.createCoffee( testCoffeeObj1() ) ;
        assertTrue( 0 < id ) ;
        assertEquals( size + 1, dao.retrieveAllCoffees().size() ) ;

        Client client = ClientBuilder.newClient() ;
        WebTarget target = client.target( "http://localhost:8080/CarsonTCB/api/coffees/json" ).path( String.valueOf( id ) ) ;

        Invocation.Builder builder = target.request( MediaType.APPLICATION_JSON ) ;
        String response = builder.get( String.class ) ;

        ObjectMapper mapper = new ObjectMapper() ;
        com.fortney.roboPojoGen.CoffeeJson results = mapper.readValue( response, CoffeeJson.class ) ;
        // get by ID should only return one table row
        assertEquals( 1, results.getCoffeeJson().size() ) ;
        CoffeeJsonItem result = results.getCoffeeJson().get( 0 ) ;

        assertEquals( result.getCoffeeId(), id ) ;
        assertEquals( result.getCoffeeName(), testCoffeeObj1().getCoffeeName() ) ;
        assertEquals( result.getDescription(), testCoffeeObj1().getDescription() ) ;
        assertEquals( result.getVendorName(), testCoffeeObj1().getVendorName() ) ;
        assertEquals( result.getVendorAddress(), testCoffeeObj1().getVendorAddress() ) ;
        assertEquals( result.getVendorCity(), testCoffeeObj1().getVendorCity() ) ;
        assertEquals( result.getVendorStProv(), testCoffeeObj1().getVendorStProv() ) ;
        assertEquals( result.getVendorMailCode(), testCoffeeObj1().getVendorMailCode() ) ;
        assertEquals( result.getVendorPhone(), testCoffeeObj1().getVendorPhone() ) ;

        dao.deleteCoffee( id ) ;
        assertTrue( size == dao.retrieveAllCoffees().size() ) ;
    }

    @Test
    public void postHtml() throws Exception {

    }

    /**
     * Add two new rows to Coffee entity using Web Service Post.
     * Verifies post response contains two IDs.
     * TODO Fails to find row by ID, possible thread issue?  Need to use Web Service to Delete too?
     * Remove added rows locally
     *
      * @throws Exception
     */
    @Test
    public void postJson() throws Exception {
        int size = dao.retrieveAllCoffees().size() ;

        List<Coffee> list = new ArrayList<>() ;
        list.add( testCoffeeObj1() ) ;
        list.add( testCoffeeObj2() ) ;
        String json = new CoffeeAPIs().convertToJson( list ) ;

        Client client = ClientBuilder.newClient() ;
        WebTarget target = client.target( "http://localhost:8080/CarsonTCB/api/coffees").path("json") ;

        Invocation.Builder builder = target.request( MediaType.APPLICATION_JSON ) ;
        Response response = builder.post( Entity.entity( json, MediaType.APPLICATION_JSON ) ) ;

        String entity = response.readEntity(String.class) ;

        // convert JSON string back into List of ID String objects
        ObjectMapper mapper = new ObjectMapper() ;
        PrimeKeysJson idList = mapper.readValue( entity, PrimeKeysJson.class ) ;

        //TODO look into Java threads... the following kluge usually worked in an RTOS.
        for ( String idStr : idList.getPrimaryKeysJson() ) {
            int failsafe = 0 ;
            while ( null == dao.retrieveCoffee( Integer.valueOf( idStr ) ) ) {
                assertTrue( 10 > failsafe++ ) ;
                Thread.sleep(1000L);
            }
            dao.deleteCoffee( Integer.valueOf( idStr ) ) ;
        }

        size = dao.retrieveAllCoffees().size() ;
        System.out.println( "size: " + size ) ;
    }

    @Test
    public void addToCoffees() throws Exception {

    }

}