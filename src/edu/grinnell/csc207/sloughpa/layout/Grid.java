package edu.grinnell.csc207.sloughpa.layout;

public class Grid 
	implements TextBlock{
	
	int width;
	int height;
	char ch;
	
	public Grid(int width, int height, char ch){
		this.width = width;
		this.height = height;
		this.ch = ch;
	}
	
	public int width(){
		return this.width;
	}
	
	public int height(){
		return this.height;
	}
	
	public String row(int i) throws Exception{
		if(i >= 0 && i <= this.height){
			String result = "";
			for(int j = 0; j < this.width; j++)
				result += this.ch;
			return result;
		}
		else{
        throw new Exception("Invalid row " + i);
		}
	}
	
	public void setContents(char ch){
		this.ch = ch;
	}
	/*
	@Override
	public void setContents(String string) {
		// TODO Auto-generated method stub
		
	}
	*/
}
