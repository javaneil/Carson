package com.neil.restservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fortney.entity.Coffee;
import com.fortney.persistence.CoffeeDao;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Neil on 3/13/2017.
 */
@Path( "/coffees" )
@Produces( {MediaType.TEXT_PLAIN, MediaType.TEXT_HTML, MediaType.APPLICATION_JSON} )
@Consumes( {MediaType.TEXT_PLAIN, MediaType.TEXT_HTML, MediaType.APPLICATION_JSON} )

public class Coffees {

    private final Logger log = Logger.getLogger( this.getClass() ) ;

    /** **********************************************************************
     * @GET
     */
    @GET
    @Path( "/html" )
    @Produces( MediaType.TEXT_HTML )
    public Response returnAllHtml() {
        CoffeeDao dao = new CoffeeDao() ;
        String output = "<html><h2>Returning All</h2>" ;
        List<Coffee> coffees = dao.retrieveAllCoffees() ;
        for ( Coffee coffee : coffees ) {
            output += convertToHtmlText( coffee ) + "<br />" ;
        }
        output += "</html>" ;
        return Response.status(200).entity(output).build() ;
    }

    @GET
    @Path( "/html/{id}" )
    @Produces( MediaType.TEXT_HTML )
    public Response returnUser( @PathParam( "id" ) String id ) {
        CoffeeDao dao = new CoffeeDao() ;
        String output = "<html><h1>Return by ID</h1>" ;
        Coffee coffee = dao.retrieveCoffee( Integer.valueOf( id ) ) ;
        output += convertToHtmlText( coffee ) ;
        output += "</html>" ;
        return Response.status( 200).entity(output).build() ;
    }

    @GET
    @Path( "/json" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response returnAllJson() {
        CoffeeDao dao = new CoffeeDao() ;
        List<Coffee> coffees = dao.retrieveAllCoffees() ;
        String output = convertToJson( coffees ) ;
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path( "/json/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response returnUserJson( @PathParam( "id" ) String id ) {
        CoffeeDao dao = new CoffeeDao() ;
        List<Coffee> coffees = new ArrayList<>() ;
        coffees.add( dao.retrieveCoffee( Integer.valueOf( id ) ) ) ;
        String output = convertToJson( coffees ) ;
        return Response.status( 200).entity(output).build() ;
    }


    /** **********************************************************************
     * @POST
     * References:
     *     https://jersey.java.net/documentation/latest/client.html
     *     http://howtodoinjava.com/jersey/jersey-restful-client-examples/
     */
    @POST
    @Path( "/" )
    public void testPOST() {
        log.info( "@POST received" ) ;
    }

    @POST
    @Path( "/html" )
    @Consumes( MediaType.TEXT_HTML )
    public Response postCoffeeHtml() {
        log.info( "@POST /html" ) ;
        return Response.status( 200).entity( "@POST postCoffeeHtml" ).build() ;
    }

    @POST
    @Path( "/json" )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response postCoffeeJson( String coffeesJson ) {
        log.info( "@POST json - " + coffeesJson ) ;
        String count = addToCoffees( coffeesJson ) ;
        return Response.status( 200).entity( "@POST postCoffeeJson " + count ).build() ;
    }


    /** **********************************************************************
     * Format raw database data into HTML
     * @param coffee - Coffee entity row
     * @return String suitable for HTML
     */
    private String convertToHtmlText( Coffee coffee ) {
        String retStr = new String() ;
        if ( null != coffee ) {
            retStr += "  " + String.valueOf(coffee.getCoffeeId()) ;
            retStr += ":  " + coffee.getCoffeeName() ;
            retStr += "<br />  " + coffee.getDescription() ;
            retStr += "<br />  " + coffee.getVendorName() ;
            retStr += "<br />  " + coffee.getVendorAddress() ;
            retStr += "<br />  " + coffee.getVendorCity() ;
            retStr += ", " + coffee.getVendorStProv() ;
            retStr += "  " + coffee.getVendorMailCode() ;
            retStr += "<br />  " + coffee.getVendorPhone() ;
        }
        else {
            retStr += "Coffee ID not found" ;
        }
        return retStr ;
    }


    /**
     * Convert list of coffee objects to JSON string
     * References:
     *      http://stackoverflow.com/questions/16022795/how-to-wrap-a-list-as-top-level-element-in-json-generated-by-jackson
     * @param list - array of Coffee objects
     * @return String - JSON
     */
    public String convertToJson( List<Coffee> list ) {
        ObjectMapper mapper = new ObjectMapper() ;
        mapper.configure( SerializationFeature.INDENT_OUTPUT, true ) ;
        ObjectWriter writer = mapper.writer().withRootName( "CoffeeJson" ) ;
        String json = null ;

        try {
//            json = mapper.writeValueAsString( list ) ;
            json = writer.writeValueAsString( list ) ;
        }
        catch ( JsonGenerationException e ) {
            log.error( "Jackson JsonGenerationException:  " , e ) ;
        }
        catch ( JsonMappingException e ) {
            log.error ( "JsonMappingException:  ", e ) ;
        }
        catch ( IOException e ) {
            log.error( "IOException:  ", e ) ;
        }
        return json ;
    }


    /**
     * @param coffeesJson - JSON string of Coffee objects to add to database
     * @return String - count of the number of rows added to table
     */
    public String addToCoffees( String coffeesJson ) {
        CoffeeDao dao = new CoffeeDao() ;
        Integer count = 0 ;
        ObjectMapper mapper = new ObjectMapper() ;

        try {
            CoffeeJson coffeeList = mapper.readValue( coffeesJson, CoffeeJson.class ) ;
            for ( Coffee row : coffeeList.getCoffeeJson() ) {
                int id = dao.createCoffee( row ) ;
                log.info( " - " + String.valueOf( ++count ) + ")  Assigned ID: " + id ) ;
            }
        }
        catch ( IOException e ) {
            log.error( "JSON conversion to Entity failed ", e ) ;
        }
        return String.valueOf( count ) ;
    }

}
