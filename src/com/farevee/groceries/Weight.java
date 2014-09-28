package com.farevee.groceries;

public class Weight {
	Units unit;
	int amount;
	
	public Weight(Units u, int amt){
		unit = u;
		amount = amt;
	}
	
	public String getUnitName(){
		return unit.name;
	}
	
	public int getUnitAmount(){
		return amount;
	}
}
