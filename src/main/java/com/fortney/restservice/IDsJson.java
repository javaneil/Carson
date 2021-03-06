package com.fortney.restservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

/**
 * Created by Neil on 3/15/2017.
 */
public class IDsJson {

    private final Logger log = Logger.getLogger( this.getClass() ) ;

    /**
     * This property is used by ObjectMapper to convert a JSON
     * string into a Java object.
      */
    @JsonProperty( "IDsJson" )
    private List<String>idsJson ;

    public List<String> getIDsJson() {
        return idsJson ;
    }

    public void setIDsJson( List<String> idsJson ) {
        this.idsJson = idsJson ;
    }


    /**
     * Convert a list of Entity Primary Keys (as String objects)
     * into a JSON formatted String.
     * To be used with REST transfers to acknowledge id's of entity
     * rows created/updated
     * Or as a list of id's to be removed/deleted.
     *
     * @param list
     * @return
     */
    public String convertToJson( List<String> list ) {
        ObjectMapper mapper = new ObjectMapper() ;
        mapper.configure( SerializationFeature.INDENT_OUTPUT, true ) ;
        ObjectWriter writer = mapper.writer().withRootName( "IDsJson" ) ;
        String json = null ;

        try {
            json = writer.writeValueAsString( list ) ;
        }
        catch ( JsonGenerationException e ) {
            log.error( "JsonGenerationException:  " , e ) ;
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
