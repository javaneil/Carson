package com.fortney.entity;

import com.fortney.util.LocalDateAttributeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * A class to represent a coffee.
 *
 * @author Neil Fortney
 */

@Entity
@Table( name = "coffee" )
public class Coffee {
    // Note: a LocalDate converter has been provided in the util package you will need it
    @Id
    @GeneratedValue( generator = "increment" )
    @GenericGenerator( name = "increment", strategy = "increment" )
    @Column( name = "coffee_id" )
    private int coffeeId;

    @Column( name = "name" )
    private String coffeeName ;

    @Column( name = "description" )
    private String description ;

    @Column( name = "vendor_name" )
    private String vendorName ;

    @Column( name = "vendor_address" )
    private String vendorAddress ;

    @Column( name = "vendor_city" )
    private String vendorCity ;

    @Column( name = "vendor_st_prov" )
    private String vendorStProv ;

    @Column( name = "vendor_mail_code" )
    private String vendorMailCode ;

    @Column( name = "vendor_phone" )
    private String vendorPhone ;

//    @Column( name = "date_of_birth" )
//    @Convert( converter = LocalDateAttributeConverter.class )
//    private LocalDate dateOfBirth ;

    /**
     * empty Constructor
     */
    public Coffee() {
    }

    public Coffee( int id, String name, String desc, String vendor, String addr,
                   String city, String st, String zip, String phone ) {
        this.coffeeId = id;
        this.coffeeName = name ;
        this.description = desc ;
        this.vendorName = vendor ;
        this.vendorAddress = addr ;
        this.vendorCity = city ;
        this.vendorStProv = st ;
        this.vendorMailCode = zip ;
        this.vendorPhone = phone ;
    }

    public int getCoffeeId() {
        return coffeeId;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName( String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName( String vendorName ) {
        this.vendorName = vendorName;
    }

    public String getVendorAddress() {
        return vendorAddress;
    }

    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
    }

    public String getVendorCity() {
        return vendorCity;
    }

    public void setVendorCity(String vendorCity) {
        this.vendorCity = vendorCity;
    }

    public String getVendorStProv() {
        return vendorStProv;
    }

    public void setVendorStProv(String vendorStProv) {
        this.vendorStProv = vendorStProv;
    }

    public String getVendorMailCode() {
        return vendorMailCode;
    }

    public void setVendorMailCode(String vendorMailCode) {
        this.vendorMailCode = vendorMailCode;
    }

    public String getVendorPhone() {
        return vendorPhone;
    }

    public void setVendorPhone(String vendorPhone) {
        this.vendorPhone = vendorPhone;
    }

/*
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
*/
}
