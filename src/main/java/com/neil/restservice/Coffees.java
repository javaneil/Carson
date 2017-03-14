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
import java.util.List;

/**
 * Created by Neil on 3/13/2017.
 */
@Path( "/" )
@Produces( {MediaType.TEXT_HTML, MediaType.APPLICATION_JSON} )
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
        String output = "" ;
        List<Coffee> coffees = dao.retrieveAllCoffees() ;
        output = convertToJson( coffees ) ;
        return Response.status(200).entity(output).build() ;
    }

    @GET
    @Path( "/json/{id}" )
    @Produces( MediaType.APPLICATION_JSON )
    public Response returnUserJson( @PathParam( "id" ) String id ) {
        CoffeeDao dao = new CoffeeDao() ;
        List<Coffee> users = new ArrayList<>() ;
        String output = "" ;

        users.add( dao.retrieveCoffee( Integer.valueOf( id ) ) ) ;
        output = convertToJson( users ) ;
        return Response.status( 200).entity(output).build() ;
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
    private String convertToJson( List<Coffee> list ) {
        ObjectMapper mapper = new ObjectMapper() ;
        mapper.configure( SerializationFeature.INDENT_OUTPUT, true ) ;
        ObjectWriter writer = mapper.writer().withRootName( "Results" ) ;
        String json = "" ;

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

}
