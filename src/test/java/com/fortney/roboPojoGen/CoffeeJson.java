package com.fortney.roboPojoGen;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class CoffeeJson{

	@JsonProperty("CoffeeJson")
	private List<CoffeeJsonItem> coffeeJson;

	public void setCoffeeJson(List<CoffeeJsonItem> coffeeJson){
		this.coffeeJson = coffeeJson;
	}

	public List<CoffeeJsonItem> getCoffeeJson(){
		return coffeeJson;
	}

	@Override
 	public String toString(){
		return 
			"CoffeeJson{" + 
			"coffeeJson = '" + coffeeJson + '\'' + 
			"}";
		}
}