package com.farevee.groceries;

public class BulkFood {
	
	public String name;
	Units unit;
	int pricePerUnit;
	int supply;
	
	public BulkFood(String nm, Units u, int ppu, int sup){
		name = nm;
		unit = u;
		pricePerUnit = ppu;
		supply = sup;
	}
	
	public boolean equals(Item i){
		if(i instanceof BulkFood){
			BulkFood that = (BulkFood) i;
			if(this.name.equals(that.name)&&
			   this.unit.name.equals(that.unit.name)&&
			   this.pricePerUnit == that.pricePerUnit&&
			   this.supply == that.supply){
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
