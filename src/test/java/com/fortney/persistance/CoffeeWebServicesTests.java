package com.fortney.persistance;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fortney.entity.Coffee;
import com.fortney.persistence.CoffeeDao;
import com.fortney.roboPojoGen.CoffeeJson;
import com.fortney.roboPojoGen.CoffeeJsonItem;
import com.neil.restservice.Coffees;
import org.glassfish.jersey.client.ClientResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static com.fortney.util.TestCommon.testCoffeeObj1;
import static com.fortney.util.TestCommon.testCoffeeObj2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * This test suite validates the Producer web services for the Coffee Entity
 * NOTE: Dependent on CoffeeDaoTests suite executing successfully
 * References:
 *      http://codesolid.com/a-simple-hibernate-mysql-and-junit-tutorial/

 * Created by Neil on 3/13/2017.
 */
public class CoffeeWebServicesTests {

    private CoffeeDao dao ;

    @Before
    public void setup() {
        dao = new CoffeeDao() ;
    }

    @After
    public void cleanup() {
        // placeholder for now...
    }

    /**
     * Get current Coffee list size locally, then compare with list retrieved from web services.
     * @throws Exception
     */
    @Test
    public void getCoffeeAll() throws Exception {
        int size = dao.retrieveAllCoffees().size() ;
        Client client = ClientBuilder.newClient() ;
        WebTarget target = client.target( "http://localhost:8080/CarsonTCB/api/json" ) ;

        Invocation.Builder builder = target.request( MediaType.APPLICATION_JSON ) ;
        String response = builder.get( String.class ) ;

        ObjectMapper mapper = new ObjectMapper() ;
        CoffeeJson results = mapper.readValue( response, CoffeeJson.class ) ;

        assertTrue( size == results.getCoffeeJson().size() ) ;
    }

    /**
     * Add a new Coffee type to list locally, then confirm it has been persisted
     * using web services
     * @throws Exception
     */
    @Test
    public void getCoffeeByID() throws Exception {
        int size = dao.retrieveAllCoffees().size() ;
        int id = dao.createCoffee( testCoffeeObj1() ) ;
        assertTrue( 0 < id ) ;
        assertEquals( size + 1, dao.retrieveAllCoffees().size() ) ;

        Client client = ClientBuilder.newClient() ;
        WebTarget target = client.target( "http://localhost:8080/CarsonTCB/api/coffees/json" ).path( String.valueOf( id ) ) ;

        Invocation.Builder builder = target.request( MediaType.APPLICATION_JSON ) ;
        String response = builder.get( String.class ) ;

        ObjectMapper mapper = new ObjectMapper() ;
        CoffeeJson results = mapper.readValue( response, CoffeeJson.class ) ;
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
    public void postCoffee() throws Exception {
        int size = dao.retrieveAllCoffees().size() ;

        List<Coffee> list = new ArrayList<>() ;
        list.add( testCoffeeObj1() ) ;
        list.add( testCoffeeObj2() ) ;
        String json = new Coffees().convertToJson( list ) ;

        Client client = ClientBuilder.newClient() ;
        WebTarget target = client.target( "http://localhost:8080/CarsonTCB/api/coffees").path("json") ;

        Invocation.Builder builder = target.request( MediaType.APPLICATION_JSON ) ;
        Response response = builder.post( Entity.entity( json, MediaType.APPLICATION_JSON ) ) ;
        String str = response.readEntity(String.class) ;

        Thread.sleep( 5000L ) ;
        System.out.println( "response.entity: " + str + "  size: " + dao.retrieveAllCoffees().size() ) ;

        if ( null != dao.retrieveCoffee( 22004 ) ) {
            dao.deleteCoffee(22004);
        }
        if ( null != dao.retrieveCoffee( 22005 ) ) {
            dao.deleteCoffee(22005);
        }
        size = dao.retrieveAllCoffees().size() ;
        System.out.println( "size: " + size ) ;
    }

}
