package com.fortney.entity;

import com.fortney.util.LocalDateAttributeConverter ;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator ;

import javax.persistence.* ;

/**
 * Created by Neil on 2/8/2017.
 */
@Entity
@Table( name = "urns" )
public class Urns {

    @Id
    @GeneratedValue
    @GenericGenerator( name = "increment", strategy = "increment" )
    @Column( name = "urn_id" )
    private int urnID ;

    @Column( name = "inventory_number" )
    private int inventoryNumber ;

    @Column( name = "brand" )
    private String brand ;

    @Column( name = "model" )
    private String model ;

    @Column( name = "commission_date" )
    private String commissionDate ;

    /**
     * Empty Constructor
     */
    public Urns() {
    }

    /**
     * runID getters & setters
      * @return
     */
    public int getUrnID() {
        return urnID;
    }

    public void setUrnID(int urnID) {
        this.urnID = urnID;
    }

    /**
     * inventoryNumber getters & setters
     * @return
     */
    public int getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(int inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    /**
     * brand getters & setters
     * @return
     */
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * model getters & setters
     * @return
     */
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    /**
     * comissionDate getters & setters
     * @return
     */
    public String getCommissionDate() {
        return commissionDate;
    }

    public void setCommissionDate(String commissionDate) {
        this.commissionDate = commissionDate;
    }

}
