package com.fortney.restservice;

import com.fasterxml.jackson.databind.ObjectMapper;
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
@Path( "/coffees" )
@Produces( {MediaType.TEXT_PLAIN, MediaType.TEXT_HTML, MediaType.APPLICATION_JSON} )
@Consumes( {MediaType.TEXT_PLAIN, MediaType.TEXT_HTML, MediaType.APPLICATION_JSON} )

public class CoffeeAPIs {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * *********************************************************************
     *
     * @GET
     */
    @GET
    @Path("/html")
    @Produces(MediaType.TEXT_HTML)
    public Response getHtmlAll() {
        CoffeeDao dao = new CoffeeDao();
        String output = "<html><h2>Returning All</h2>";
        List<Coffee> coffees = dao.retrieveAllCoffees();
        for (Coffee coffee : coffees) {
            output += convertToHtmlText(coffee) + "<br />";
        }
        output += "</html>";
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/html/{id}")
    @Produces(MediaType.TEXT_HTML)
    public Response getHtmlById(@PathParam("id") String id) {
        CoffeeDao dao = new CoffeeDao();
        String output = "<html><h1>Return by ID</h1>";
        Coffee coffee = dao.retrieveCoffee(Integer.valueOf(id));
        output += convertToHtmlText(coffee);
        output += "</html>";
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJsonAll() {
        CoffeeDao dao = new CoffeeDao() ;
        CoffeeJson json = new CoffeeJson() ;
        List<Coffee> coffees = dao.retrieveAllCoffees() ;
        String output = json.convertToJson( coffees ) ;
        return Response.status(200 ).entity( output ).build() ;
    }

    @GET
    @Path("/json/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJsonById(@PathParam("id") String id) {
        CoffeeDao dao = new CoffeeDao() ;
        CoffeeJson json = new CoffeeJson() ;
        List<Coffee> coffees = new ArrayList<>();
        coffees.add( dao.retrieveCoffee( Integer.valueOf(id) ) ) ;
        String output = json.convertToJson( coffees ) ;
        return Response.status(200 ).entity( output ).build() ;
    }


    /**
     * *********************************************************************
     *
     * @POST References:
     * https://jersey.java.net/documentation/latest/client.html
     * http://howtodoinjava.com/jersey/jersey-restful-client-examples/
     */
    @POST
    @Path("/")
    public Response post() {
        log.info("@POST received");
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/html")
    @Consumes(MediaType.TEXT_HTML)
    public Response postHtml() {
        log.info("@POST /html");
        return Response.status(200).entity("@POST postHtml").build();
    }

    @POST
    @Path("/json")
    @Consumes( MediaType.APPLICATION_JSON )
    public Response postJson( String coffeesJson ) {
        log.info( "@POST /json - " + coffeesJson ) ;
        String response = addToCoffees( coffeesJson ) ;
        return Response.status(200).entity(response).build();
    }

    @POST
    @Path("/json/delete")
    @Consumes( MediaType.APPLICATION_JSON )
    public Response postJsonDelete( String idsJson ) {
        log.info( "@POST /json/delete " ) ;
        String response = deleteFromCoffees( idsJson ) ;
        return Response.status( Response.Status.OK ).entity( response ).build() ;
    }


    /**
     * *********************************************************************
     */
    @DELETE
    @Path("/")
    public Response delete() {
        log.info("@DELETE received") ;
        return Response.status( Response.Status.BAD_REQUEST ).build() ;
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById( @PathParam("id") String id ) {
        log.info("@DELETE {id} " ) ;
        if( null != new CoffeeDao().deleteCoffee( Integer.valueOf( id ) ) ) {
            return Response.status( Response.Status.OK ).build() ;
        }
        else {
            return Response.status( Response.Status.OK).build();
        }
    }

    @DELETE
    @Path("/json")
    @Consumes( MediaType.APPLICATION_JSON )
    public Response deleteJson( String idsJson ) {
        log.info( "@DELETE /json " ) ;
        String response = deleteFromCoffees( idsJson ) ;
        return Response.status( Response.Status.OK ).entity( response ).build() ;
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
     * Use ObjectMapper to convert JSON string to a CoffeeJson object
     * that consists of a List of Coffee objects.
     * Iterate through the list of Coffee objects adding each one to
     * the Coffee entity.
     *
     * @param coffeesJson - JSON string of Coffee objects to add to database
     * @return String - JSON string with a list of IDs to the rows added to the table
     */
    public String addToCoffees( String coffeesJson ) {
        ObjectMapper mapper = new ObjectMapper() ;  // JSON string to Java object mapper
        CoffeeDao dao = new CoffeeDao() ;           // Data Access Object to MySQL database
        IDsJson json = new IDsJson() ;              // ID list to JSON
        String retIDs = null ;

        try {
            CoffeeJson coffeeList = mapper.readValue( coffeesJson, CoffeeJson.class ) ;

            List<String> idList = new ArrayList<>() ;   // list of ids assigned to new rows in database)
            for ( Coffee row : coffeeList.getCoffeeJson() ) {
                int id = dao.createCoffee( row ) ;      // create and commit to database
                idList.add( String.valueOf( id ) ) ;    // add new id (primary key) to list
                log.info( " " + String.valueOf( idList.size() ) + ")  Assigned ID: " + id ) ;
            }
            // Convert list of IDs to JSON for Web Service response Entity
            retIDs = json.convertToJson( idList ) ;
        }
        catch ( IOException e ) {
            log.error( "JSON conversion to Entity failed ", e ) ;
        }
        return retIDs ;
    }

    /**
     * Use ObjectMapper to convert JSON string to a List of ID Strings
     * Interate through the list deleting each one from the Entity.
     *
     * @param idsJson - JSON string of Coffee IDs to Delete from database
     * @return String - JSON string with a list of IDs successfully deleted from table
     */
    public String deleteFromCoffees( String idsJson ) {
        ObjectMapper mapper = new ObjectMapper() ;  // JSON string to Java object mapper
        CoffeeDao dao = new CoffeeDao() ;           // Data Access Object to MySQL database
        IDsJson json = new IDsJson() ;
        String retIDs = null ;

        try {
            IDsJson idList = mapper.readValue( idsJson, IDsJson.class ) ;

            List<String> idsDeleted = new ArrayList<>() ;   // list of ids successfully deleted from database
            for ( String id : idList.getIDsJson() ) {
                if( null != dao.deleteCoffee( Integer.valueOf( id ) ) ) {
                    idsDeleted.add( id ) ;  // acknowledge removal
                }
            }
            // Convert list of IDs to JSON for Web Service response Entity
            retIDs = json.convertToJson( idsDeleted ) ;
        }
        catch ( IOException e ) {
            log.error( "JSON conversion to ID List failed" ) ;
        }
        return retIDs ;
    }

}
