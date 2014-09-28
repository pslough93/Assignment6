package com.farevee.shopping;

import java.io.PrintWriter;
import java.util.ArrayList;

import com.farevee.groceries.*;
import com.farevee.groceries.Package;

public class Cart {
	
	ArrayList<Item> itemsInCart;
	int totalCost;
	int numThings;
	int numEntries;
	int[] weight;
	
	public Cart(){
		itemsInCart = new ArrayList<Item>();
		totalCost = 0;
		numThings = 0;
		numEntries = 0;
		weight = new int[4];
		for(int i = 0; i < 4; i++){
			weight[i] = 0;
		}
	}
	
	public void add(Item i){
		itemsInCart.add(i);
		totalCost += i.getPrice();
		numEntries++;
		if(i instanceof ManyPackages){
			ManyPackages mp = (ManyPackages) i;
			numThings += mp.getAmount();
		}
		else{
			numThings++;
		}
		Weight wt = i.getWeight();
		switch(wt.getUnitName()){
		case "pound": weight[0] += wt.getUnitAmount();
					break;
		case "ounce": weight[1] += wt.getUnitAmount();
					break;
		case "kilogram": weight[2] += wt.getUnitAmount();
					break;
		case "gram": weight[3] += wt.getUnitAmount();
					break;
		}
	}
	
	public int numThings(){
		return numThings;
	}
	
	public int numEntries(){
		return numEntries;
	}
	
	public void printContents(PrintWriter pen){
		for(int i = 0; i < itemsInCart.size(); i++){
			pen.println(itemsInCart.get(i).toString());
		}
	}
	
	public int getPrice(){
		return totalCost;
	}
	
	public int[] getWeight(){
		return weight;
	}
	
	public void remove(String name){
		for(int i = 0; i < itemsInCart.size(); i++){
			if(name.equals(itemsInCart.get(i).getName())){
				totalCost -= itemsInCart.get(i).getPrice();
				numEntries--;
				if(itemsInCart.get(i) instanceof ManyPackages){
					ManyPackages mp = (ManyPackages) itemsInCart.get(i);
					numThings -= mp.getAmount();
				}
				else{
					numThings--;
				}
				Weight wt = itemsInCart.get(i).getWeight();
				switch(wt.getUnitName()){
				case "pound": weight[0] -= wt.getUnitAmount();
							break;
				case "ounce": weight[1] -= wt.getUnitAmount();
							break;
				case "kilogram": weight[2] -= wt.getUnitAmount();
							break;
				case "gram": weight[3] -= wt.getUnitAmount();
							break;
				}
				itemsInCart.remove(i);
				i--;
			}
		}
	}
	
	public void merge(){
		int index = 0;
		while(index < itemsInCart.size()){
			//if item is a package
			if(itemsInCart.get(index) instanceof Package){
				//cast to item to package
				Package indexItem = (Package) itemsInCart.get(index);
				//for every item beyond it
				for(int j = index + 1; j < itemsInCart.size(); j++){
					//find if item is a package
					if(itemsInCart.get(j) instanceof Package){
						//if so, cast to new package
						Package curItem = (Package) itemsInCart.get(j);
						//if they equal each other
						if(curItem.equals(indexItem)){
							//make new manyPackage
							itemsInCart.add(new ManyPackages(curItem, 2));
							//remove others
							numEntries --;
							itemsInCart.remove(index + 1);
							itemsInCart.remove(j);
						}//if
					}//if
					//or if item is a ManyPackage
					else if(itemsInCart.get(j) instanceof ManyPackages){
						//cast to manyPackage
						ManyPackages curItemMP = (ManyPackages) itemsInCart.get(j);
						//cast package part of item to package
						Package curItem = curItemMP.getPackage();
						//if packages are equal
						if(curItem.equals(indexItem)){
							//make new manyPackage
							itemsInCart.add(index, new ManyPackages(curItem, (curItemMP.getAmount() + 1)));
							//remove others
							numEntries--;
							itemsInCart.remove(index + 1);
							itemsInCart.remove(j);
						}//if
					}//else if
				}//for
			}//if
			//if item is a ManyPackage
			if(itemsInCart.get(index) instanceof ManyPackages){
				//cast to ManyPackages
				ManyPackages indexItem = (ManyPackages) itemsInCart.get(index);
				for(int j = index + 1; j < itemsInCart.size(); j++){
					//if item is package
					if(itemsInCart.get(j) instanceof Package){
						//cast to package
						Package curItem = (Package) itemsInCart.get(j);
						//if package part of indexitem equals curItem.
						if(indexItem.getPackage().equals(curItem)){
							//add updated ManyPackages
							itemsInCart.add(index, new ManyPackages(curItem, indexItem.getAmount() + 1));
							//remove others
							numEntries--;
							itemsInCart.remove(index + 1);
							itemsInCart.remove(j);
						}//if
					}//if
					else if(itemsInCart.get(j) instanceof ManyPackages){
						ManyPackages curItem = (ManyPackages) itemsInCart.get(j);
						if(indexItem.getPackage().equals(curItem.getPackage())){
							itemsInCart.add(index, new ManyPackages(curItem.getPackage(), indexItem.getAmount() + curItem.getAmount()));
							numEntries--;
							itemsInCart.remove(index + 1);
							itemsInCart.remove(j);
						}//if
					}//else if
				}//for
			}//if
			if(itemsInCart.get(index) instanceof BulkItem){
				BulkItem indexItem = (BulkItem) itemsInCart.get(index);
				for(int j = index + 1; j < itemsInCart.size(); j++){
					if(itemsInCart.get(j) instanceof BulkItem){
						BulkItem curItem = (BulkItem) itemsInCart.get(j);
						
						if(indexItem.getFood().equals(curItem.getFood())){
							System.out.println("Got here");
							BulkFood food = indexItem.getFood();
							Units unit = indexItem.getUnits();
							int amt = indexItem.getWeight().getUnitAmount() + curItem.getWeight().getUnitAmount();
							itemsInCart.add(index, new BulkItem(food, unit, amt));
							numEntries--;
							itemsInCart.remove(index + 1);
							itemsInCart.remove(j);
						}
					}
				}
			}
			index++;
		}//while
	}//merge()
}
