package com.farevee.groceries;

public class ManyPackages implements Item{
	Package type;
	int amount;
	
	public ManyPackages(Package pack, int amt){
		type = pack;
		amount = amt;
	}
	
	public Weight getWeight(){
		return new Weight(type.weight.unit, type.weight.amount*amount);
	}
	
	public int getPrice(){
		return type.price*amount;
	}
	
	public String toString(){
		return amount + " x " + type.toString();
	}
	
	public int getAmount(){
		return amount;
	}
	
	public Package getPackage(){
		return type;
	}
	
	public String getName(){
		return type.name;
	}
	
	public boolean equals(Item i){
		return i.equals(this);
	}//equals(Item)
}
