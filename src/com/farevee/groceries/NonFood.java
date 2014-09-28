package com.farevee.groceries;

public class NonFood implements Item{
	public String name;
	Weight weight;
	int price;
	
	public NonFood(String nm, Weight wt, int pr){
		name = nm;
		weight = wt;
		price = pr;
	}//NonFood(String, Weight, int)
	
	public Weight getWeight(){
		return this.weight;
	}//getWeight()
	
	public int getPrice(){
		return this.price;
	}//getPrice()
	
	public String toString(){
		return name;
	}//toString//
	
	public String getName(){
		return name;
	}
	
	public boolean equals(Item i){
		if(i instanceof NonFood){
			NonFood that = (NonFood) i;
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
