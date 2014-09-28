package com.farevee.groceries;

public class BulkItem implements Item{
	
	BulkFood food;
	Units unit;
	int amount;
	
	public BulkItem(BulkFood bf, Units u, int amt){
		food = bf;
		unit = u;
		amount = amt;
	}
	
	public String toString(){
		if(amount == 1){
			String result = "" + amount + " " + unit.name + " of " + food.name;
			return result;
		}
		else{
			String result = "" + amount + " " + unit.plural + " of " + food.name;
			return result;
		}
	}
	
	public Weight getWeight(){
		return new Weight(unit, amount);
	}
	
	public int getPrice(){
		return amount * food.pricePerUnit;
	}
	
	public String getName(){
		return food.name;
	}
	
	public BulkFood getFood(){
		return food;
	}
	
	public Units getUnits(){
		return unit;
	}
	public boolean equals(Item i){
		if(i instanceof BulkItem){
			BulkItem that = (BulkItem) i;
			if(this.food.equals(that.food)&&
			   this.unit.name.equals(that.unit.name)&&
			   this.amount == that.amount){
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
