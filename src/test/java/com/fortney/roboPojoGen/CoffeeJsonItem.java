package com.fortney.roboPojoGen;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class CoffeeJsonItem{

	@JsonProperty("vendorMailCode")
	private String vendorMailCode;

	@JsonProperty("coffeeName")
	private String coffeeName;

	@JsonProperty("vendorPhone")
	private String vendorPhone;

	@JsonProperty("coffeeId")
	private int coffeeId;

	@JsonProperty("vendorStProv")
	private String vendorStProv;

	@JsonProperty("description")
	private String description;

	@JsonProperty("vendorCity")
	private String vendorCity;

	@JsonProperty("vendorName")
	private String vendorName;

	@JsonProperty("vendorAddress")
	private String vendorAddress;

	public void setVendorMailCode(String vendorMailCode){
		this.vendorMailCode = vendorMailCode;
	}

	public String getVendorMailCode(){
		return vendorMailCode;
	}

	public void setCoffeeName(String coffeeName){
		this.coffeeName = coffeeName;
	}

	public String getCoffeeName(){
		return coffeeName;
	}

	public void setVendorPhone(String vendorPhone){
		this.vendorPhone = vendorPhone;
	}

	public String getVendorPhone(){
		return vendorPhone;
	}

	public void setCoffeeId(int coffeeId){
		this.coffeeId = coffeeId;
	}

	public int getCoffeeId(){
		return coffeeId;
	}

	public void setVendorStProv(String vendorStProv){
		this.vendorStProv = vendorStProv;
	}

	public String getVendorStProv(){
		return vendorStProv;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setVendorCity(String vendorCity){
		this.vendorCity = vendorCity;
	}

	public String getVendorCity(){
		return vendorCity;
	}

	public void setVendorName(String vendorName){
		this.vendorName = vendorName;
	}

	public String getVendorName(){
		return vendorName;
	}

	public void setVendorAddress(String vendorAddress){
		this.vendorAddress = vendorAddress;
	}

	public String getVendorAddress(){
		return vendorAddress;
	}

	@Override
 	public String toString(){
		return 
			"CoffeeJsonItem{" + 
			"vendorMailCode = '" + vendorMailCode + '\'' + 
			",coffeeName = '" + coffeeName + '\'' + 
			",vendorPhone = '" + vendorPhone + '\'' + 
			",coffeeId = '" + coffeeId + '\'' + 
			",vendorStProv = '" + vendorStProv + '\'' + 
			",description = '" + description + '\'' + 
			",vendorCity = '" + vendorCity + '\'' + 
			",vendorName = '" + vendorName + '\'' + 
			",vendorAddress = '" + vendorAddress + '\'' + 
			"}";
		}
}