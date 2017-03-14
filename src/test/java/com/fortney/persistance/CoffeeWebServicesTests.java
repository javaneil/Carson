package com.fortney.persistance;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fortney.persistence.CoffeeDao;
import com.fortney.roboPojoGen.Results;
import com.fortney.roboPojoGen.ResultsItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.fortney.util.TestCommon.testCoffeeObj;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Neil on 3/13/2017.
 */
public class CoffeeWebServicesTests {

    private CoffeeDao dao ;

    /**
     * References:
     *      http://codesolid.com/a-simple-hibernate-mysql-and-junit-tutorial/
     */

    @Before
    public void setup() {
        dao = new CoffeeDao() ;
    }

    @After
    public void cleanup() {
        // placeholder for now...
    }

    @Test
    public void addCoffee() throws Exception {

        int id = 22004 ; //dao.createCoffee( testCoffeeObj() ) ;
//        assertTrue( 0 < id ) ;

        Client client = ClientBuilder.newClient() ;
        WebTarget target = client.target( "http://localhost:8080/CarsonTCB/api/json" ) ; //.path( String.valueOf( id ) ) ;

        Invocation.Builder builder = target.request( MediaType.APPLICATION_JSON ) ;
        String response = builder.get( String.class ) ;

        ObjectMapper mapper = new ObjectMapper() ;
        Results results = mapper.readValue( response, Results.class ) ;
        ResultsItem coffee = results.getResults().get(0) ;

//        dao.deleteCoffee( id ) ;

//        assertEquals( "???", coffee ) ;
        System.out.println( coffee ) ;
    }

}
