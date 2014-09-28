package com.farevee.groceries;

public class Package implements Item{
	
	public String name;
	Weight weight;
	int price;
	
	public Package(String nm, Weight wt, int pr){
		name = nm;
		weight = wt;
		price = pr;
	}
	
	public String toString(){
		String result = "" + weight.amount + " " + weight.unit.abbrev + " package of " + name;
		return result;
	}
	
	public Weight getWeight(){
		return this.weight;
	}
	
	public int getPrice(){
		return this.price;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean equals(Item i){
		if(i instanceof Package){
			Package that = (Package) i;
			if(this.name.equals(that.name)&&
			   this.weight.amount == that.weight.amount&&
			   this.weight.unit.name.equals(that.weight.unit.name)&&
			   this.price == that.price){
				return true;
			}//if
			else{
				return false;
			}//else	
		}//if
		else{
			return false;
		}//else	
	}//equals(Item)
}
