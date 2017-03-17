package com.fortney.restservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fortney.entity.Coffee;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

/**
 * Created by Neil on 3/14/2017.
 */
public class CoffeeJson {

    private final Logger log = Logger.getLogger( this.getClass() ) ;

    @JsonProperty( "CoffeeJson" )
    private List<Coffee> coffeeJson ;

    public void setCoffeeJson(List<Coffee> coffeeJson){
        this.coffeeJson = coffeeJson ;
    }

    public List<Coffee> getCoffeeJson() {
        return coffeeJson ;
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

}

