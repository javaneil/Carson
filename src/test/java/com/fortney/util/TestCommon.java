package com.fortney.util;

import com.fortney.entity.Coffee;

import java.time.LocalDate;

/**
 * Created by Neil on 3/13/2017.
 */
public class TestCommon {
    /**
     * Create Coffee entity / object
     */
    public static Coffee testCoffeeObj1() {
        Coffee retObj = new Coffee("Yuckban", "Best choice if you are trying to quit drinking coffee",
                "Queequegs", "123 Oak Street", "Seattle", "WA", "98101",
                "1 800 555 1212" ) ;
        return retObj ;
    }

    public static Coffee testCoffeeObj2() {
        Coffee retObj = new Coffee("Mucka", "A truely disgusting cup of mud",
                "Queequegs", "123 Oak Street", "Seattle", "WA", "98101",
                "1 800 555 1212" ) ;
        return retObj ;
    }

    public static LocalDate testDate () {
        LocalDate retDate = LocalDate.parse( "1956-12-31" ) ;
        return retDate ;
    }

}
