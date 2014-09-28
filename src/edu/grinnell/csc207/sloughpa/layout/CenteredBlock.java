package edu.grinnell.csc207.sloughpa.layout;

public class CenteredBlock implements TextBlock{

	TextBlock contents;
	int width;
	
	public CenteredBlock(TextBlock tb, int width){
		contents = tb;
		this.width = width;
	}
	
	public String row(int i) throws Exception{
		if(this.width < contents.width()){
			throw new Exception("Invalid width");
		}
		if(i >= 0 && i < this.height()){
			int spaces = (this.width - contents.width())/2;
			int remaining = (this.width - contents.width()) - spaces;
			String result = "";
			for(int j = 0; j < spaces; j++)
				result += ' ';
			result += contents.row(i);
			for(int k = 0; k < remaining; k++){
				result += ' ';
			}
			return result;
		}
		else{
			throw new Exception("Invalid Height " + i);
		}
	}
	
	public int width(){
		return this.width;
	}
	
	public int height(){
		return contents.height();
	}
	
	public void setContents(String string){
		contents = new TextLine(string);
	}
}
