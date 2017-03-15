package com.fortney.restservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fortney.entity.Coffee;

import java.util.List;

/**
 * Created by Neil on 3/14/2017.
 */
public class CoffeeJson {

    @JsonProperty( "CoffeeJson" )
    private List<Coffee> coffeeJson ;

    public void setCoffeeJson(List<Coffee> coffeeJson){
        this.coffeeJson = coffeeJson ;
    }

    public List<Coffee> getCoffeeJson() {
        return coffeeJson ;
    }

}

