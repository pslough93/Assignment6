package edu.grinnell.csc207.sloughpa.layout;

public class RightJustified implements TextBlock{
	
	TextBlock contents;
	int width;
	
	public RightJustified(TextBlock tb, int width){
		contents = tb;
		this.width = width;
	}
	
	public String row(int i) throws Exception{
		if(this.width < contents.width()){
			throw new Exception("invalid width");
		}
		if(i >= 0 && i < contents.height()){
			int spaces = this.width - contents.width();
			String result = "";
			for(int j = 0; j < spaces; j++){
				result += ' ';
			}
			result += contents.row(i);
			return result;
		}
		else{
			throw new Exception("invalid row " + i);
		}
	}
	
	public int width(){
		return this.width;
	}
	
	public int height(){
		return contents.height();
	}
}
