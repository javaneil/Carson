package com.fortney.restservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Neil on 3/15/2017.
 */
public class IDsJsonTest {
    @Test
    public void convertToJson() throws Exception {
        IDsJson idListJson = new IDsJson() ;

        List<String> testList = new ArrayList<>() ;
        testList.add( "22001" ) ;
        testList.add( "22002" ) ;
        testList.add( "22003" ) ;
        testList.add( "22004" ) ;
        testList.add( "22005" ) ;

        // UUT - IDsJson.convertToJson() method
        String jsonStr = idListJson.convertToJson( testList ) ;

        // now convert JSON string back into List of String object and compare
        ObjectMapper mapper = new ObjectMapper() ;
        IDsJson resultList = mapper.readValue( jsonStr, IDsJson.class ) ;

        assertEquals( testList.size(), resultList.getIDsJson().size() ) ;
        for ( Integer idx = 0 ; idx < resultList.getIDsJson().size(); idx++ ) {
            assertEquals( testList.indexOf( idx ), resultList.getIDsJson().indexOf( idx ) ) ;
        }
    }

}