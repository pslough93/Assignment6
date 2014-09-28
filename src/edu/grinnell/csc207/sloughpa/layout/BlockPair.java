package edu.grinnell.csc207.sloughpa.layout;

public class BlockPair implements TextBlock{
	TextBlock contents;
	
	public BlockPair(TextBlock tb){
		contents = tb;
	}
	
	public String row(int i) throws Exception{
		if(i >= 0 && i < contents.height()){
			String result = contents.row(i) + contents.row(i);
			return result;
		}
		else{
			throw new Exception("invalid row "+ i);
		}
	}
	
	public int width(){
		return contents.width();
	}
	
	public int height(){
		return contents.height();
	}
	
	/*
	public void setContents(String string){
		contents = new TextLine(string);
	}
	*/
}
