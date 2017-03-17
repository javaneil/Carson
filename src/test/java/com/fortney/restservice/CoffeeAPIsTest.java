package com.fortney.restservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fortney.entity.Coffee;
import com.fortney.persistence.CoffeeDao;
import org.apache.log4j.Logger;
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

    private final Logger log = Logger.getLogger(this.getClass());

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

    /** **********************************************************************
     * Test helper methods:
     *      addToCoffees()
     *      deleteFromCoffees()
     */
    @Test
    public void addToDeleteFromCoffees() throws Exception {
        CoffeeAPIs api = new CoffeeAPIs() ;
        ObjectMapper mapper = new ObjectMapper() ;

        // generate some new rows to add
        List<Coffee> list = new ArrayList<>() ;
        list.add( testCoffeeObj1() ) ;
        list.add( testCoffeeObj2() ) ;

        // convert list of Coffee objects to JSON string & add to database
        String json = new CoffeeJson().convertToJson( list ) ;
        String addedIdsJson = api.addToCoffees( json ) ;
        // convert JSON response back to java object
        IDsJson addedIdObj = mapper.readValue( addedIdsJson, IDsJson.class ) ;
        assertEquals( list.size(), addedIdObj.getIDsJson().size() ) ;

        // use JSON list of IDs to delete from database
        String deletedIdsJson = api.deleteFromCoffees( addedIdsJson ) ;
        // convert JSON response back to java object
        IDsJson deletedIdsObj = mapper.readValue( deletedIdsJson, IDsJson.class ) ;
        assertEquals( list.size(), deletedIdsObj.getIDsJson().size() ) ;

        // compare that ID lists match
        //TODO there's got to be an Object "compare contents" assert...
        for ( int idx = 0 ; idx < list.size() ; idx++ ) {
            assertEquals( addedIdObj.getIDsJson().indexOf( idx ), deletedIdsObj.getIDsJson().indexOf( idx ) ) ;
        }
        log.info( "addToDeleteFromCoffees() test complete" ) ;
    }


    /** **********************************************************************
     * Test Web Service methods
     * NOTE: Must first launch a separate instance of TomEE
     */

    /**
     * Get current Coffee Entity size using Web Services.
     * @throws Exception
     */
    @Test
    public void getJsonAll() throws Exception {
        CoffeeJson results = retrieveJsonAll() ;
        assertTrue( 0 < results.getCoffeeJson().size() ) ;
    }


    /**
     * Add a new Coffee type to list locally, then confirm it has been persisted
     * using web services
     * @throws Exception
     */
    @Test
    public void getJsonById() throws Exception {
        // get current table size
        int size = retrieveJsonAll().getCoffeeJson().size() ;

        // generate some new rows to add
        List<Coffee> list = new ArrayList<>() ;
        list.add( testCoffeeObj1() ) ;

        // add Coffee row to database using Web Services
        IDsJson ids = createJson( list ) ;
        assertEquals( list.size(), ids.getIDsJson().size() ) ;
        // verify size increased by list.size()
        assertEquals( size + list.size(), retrieveJsonAll().getCoffeeJson().size() ) ;

        String id = ids.getIDsJson().get(0) ;
        Coffee result = getJsonById( id ) ;

        assertEquals( result.getCoffeeId(), Integer.parseInt( id ) ) ;
        assertEquals( result.getCoffeeName(), testCoffeeObj1().getCoffeeName() ) ;
        assertEquals( result.getDescription(), testCoffeeObj1().getDescription() ) ;
        assertEquals( result.getVendorName(), testCoffeeObj1().getVendorName() ) ;
        assertEquals( result.getVendorAddress(), testCoffeeObj1().getVendorAddress() ) ;
        assertEquals( result.getVendorCity(), testCoffeeObj1().getVendorCity() ) ;
        assertEquals( result.getVendorStProv(), testCoffeeObj1().getVendorStProv() ) ;
        assertEquals( result.getVendorMailCode(), testCoffeeObj1().getVendorMailCode() ) ;
        assertEquals( result.getVendorPhone(), testCoffeeObj1().getVendorPhone() ) ;

        // delete added row and verify size is same as when test started
        assertEquals( id, deleteJson( ids ).getIDsJson().get(0) ) ;
        assertEquals( size,retrieveJsonAll().getCoffeeJson().size() ) ;
    }


    @Test
    public void postHtml() throws Exception {

    }

    /**
     * Add two new rows to Coffee entity using Web Service Post.
     * Verifies post response contains two IDs.
     * TODO Fails to find row by ID, possible thread issue?  Need to use Web Service to Delete too?
     * Remove added rows
     *
      * @throws Exception
     */
    @Test
    public void postJson() throws Exception {
        // get current table size
        int size = retrieveJsonAll().getCoffeeJson().size() ;

        // generate some new rows to add
        List<Coffee> list = new ArrayList<>() ;
        list.add( testCoffeeObj1() ) ;
        list.add( testCoffeeObj2() ) ;

        // add Coffee rows to database using Web Services
        IDsJson ids = createJson( list ) ;
        assertEquals( list.size(), ids.getIDsJson().size() ) ;
        // verify size increased by list.size()
        assertEquals( size + list.size(), retrieveJsonAll().getCoffeeJson().size() ) ;

        // delete same rows from database also using Web Services
        ids = deleteJson( ids ) ;
        assertEquals( list.size(), ids.getIDsJson().size() ) ;
        // verify size restored to original
        assertEquals( size, retrieveJsonAll().getCoffeeJson().size() ) ;
    }

/*
    @Test
    public void delete() throws Exception {
        Client client = ClientBuilder.newClient() ;
        WebTarget target = client.target( "http://localhost:8080/CarsonTCB/api/coffees" ) ;
        Invocation.Builder builder = target.request( MediaType.APPLICATION_JSON ) ;
        Response response = builder.delete( Response.class ) ;
        System.out.println( response.getStatus() ) ;
    }
*/

    /** **********************************************************************
     * Helper Methods
     */

    /**
     * Get all rows from the database Coffee Entity using Web Services
     *
     * @return - CoffeeJson object with List of Coffee objects (rows) retrieved
     * @throws Exception
     */
    private CoffeeJson retrieveJsonAll() throws Exception {
        Client client = ClientBuilder.newClient() ;
        WebTarget target = client.target( "http://localhost:8080/CarsonTCB/api/coffees/json" ) ;

        Invocation.Builder builder = target.request( MediaType.APPLICATION_JSON ) ;
        String get = builder.get( String.class ) ;

        // convert JSON string from Web Service to List of Coffee objects
        ObjectMapper mapper = new ObjectMapper() ;
        CoffeeJson results = mapper.readValue( get, CoffeeJson.class ) ;

        return results ;
    }


    private Coffee getJsonById( String id ) throws Exception {
        Client client = ClientBuilder.newClient() ;
        WebTarget target = client.target("http://localhost:8080/CarsonTCB/api/coffees/json").path( id ) ;

        Invocation.Builder builder = target.request( MediaType.APPLICATION_JSON ) ;
        String response = builder.get( String.class ) ;

        ObjectMapper mapper = new ObjectMapper() ;
        CoffeeJson results = mapper.readValue( response, CoffeeJson.class ) ;
        // get by ID should only return one table row
        assertEquals(1, results.getCoffeeJson().size() ) ;
        Coffee result = results.getCoffeeJson().get(0) ;

        return result ;
    }


    private IDsJson createJson( List<Coffee> list ) throws Exception {
        // convert list of Coffee objects to JSON string
        String json = new CoffeeJson().convertToJson( list ) ;

        Client client = ClientBuilder.newClient() ;
        WebTarget target = client.target( "http://localhost:8080/CarsonTCB/api/coffees").path("json") ;

        Invocation.Builder builder = target.request( MediaType.APPLICATION_JSON ) ;
        Response response = builder.post( Entity.entity( json, MediaType.APPLICATION_JSON ) ) ;
        String entity = response.readEntity( String.class ) ;

        ObjectMapper mapper = new ObjectMapper() ;
        IDsJson results = mapper.readValue( entity, IDsJson.class ) ;

        return results ;
    }

/*
    private void deleteJson( IDsJson ids ) throws Exception {

        Client client = ClientBuilder.newClient() ;
        WebTarget target = null ;
        Invocation.Builder builder = null ;
        Response response = null ;

        for( String id : ids.getIDsJson() ) {
            target = client.target("http://localhost:8080/CarsonTCB/api/coffees").path(id);
            builder = target.request( MediaType.APPLICATION_JSON ) ;
            response = builder.delete( Response.class ) ;

            System.out.println( response.getStatus() ) ;
        }
    }
*/

    private IDsJson deleteJson( IDsJson ids ) throws Exception {
        // convert list of Coffee objects to JSON string
        String json = new IDsJson().convertToJson( ids.getIDsJson() ) ;

        Client client = ClientBuilder.newClient() ;
        WebTarget target = client.target( "http://localhost:8080/CarsonTCB/api/coffees/json/delete" ) ;

        Invocation.Builder builder = target.request( MediaType.APPLICATION_JSON ) ;
        Response response = builder.post( Entity.entity( json, MediaType.APPLICATION_JSON ) ) ;
        String entity = response.readEntity( String.class ) ;

        ObjectMapper mapper = new ObjectMapper() ;
        IDsJson results = mapper.readValue( entity, IDsJson.class ) ;

        return results ;
    }


}