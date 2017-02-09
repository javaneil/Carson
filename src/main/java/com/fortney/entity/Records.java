package com.fortney.entity ;

import com.fortney.util.LocalDateAttributeConverter ;
import org.hibernate.annotations.GenericGenerator ;

import javax.persistence.* ;


/**
 * Created on 2/8/2017.
 * @suthor Neil Fortney
 */

// REFERENCE: http://www.codejava.net/frameworks/hibernate/hibernate-one-to-one-mapping-with-foreign-key-annotations-example

@Entity
@Table( name = "records" )
public class Records {

    @Id
    @GeneratedValue
    @GenericGenerator( name = "increment", strategy = "increment" )
    @Column( name = "record_id" )
    private int recordID ;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "urn_id" )
    private Urns urnID ;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "coffee_id" )
    private Coffee coffeeID ;

//    @Column( name = "weather_id" )
//    private Weather weather ;

    @Column( name = "current_location" )
    private String currentLocation ;

    @Column( name = "start_date_time" )
    private String startDateTime ;


    /**
     * Empty Constructor
     */
    public Records() {
        System.out.println( "Records Constructor" ) ;
    }

    /**
     * RecordID getters & setters
     * @return
     */
    public int getRecordID() {
        return recordID;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

    /**
     * urnID getters & setters
     * @return
     */
    public Urns getUrnID() {
        return urnID;
    }

    public void setUrnID(Urns urnID) {
        this.urnID = urnID;
    }

    /**
     * coffeeID getters & setters
     * @return
     */
    public Coffee getCoffeeID() {
        return coffeeID;
    }

    public void setCoffeeID(Coffee coffeeID) {
        this.coffeeID = coffeeID;
    }

    /**
     * currentLocation getters & setters
     * @return
     */
    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    /**
     * startDateTime getters & setters
     * @return
     */
    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

}
