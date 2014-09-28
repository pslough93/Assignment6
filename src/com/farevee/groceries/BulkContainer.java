package com.farevee.groceries;

public class BulkContainer extends BulkItem{
	
	String container;
	
	public BulkContainer(String cont, BulkFood food, Units u, int amt){
		super(food, u, amt);
		container = cont;
	}

	@Override
	public String toString(){
		return container + " of " + super.toString();
	}
	
	public boolean equals(Item i){
		if(i instanceof BulkContainer){
			BulkContainer that = (BulkContainer) i;
			if(this.container.equals(that.container)&&
			   this.equals(that)){
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
