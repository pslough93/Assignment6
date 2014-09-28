package edu.grinnell.csc207.sloughpa.layout;

import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.2 of September 2014
 */
public class TBExpt
{
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args)
    throws Exception
  {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    TextLine block = new TextLine("Hello");
    TextBlock block1 = new BlockPair(block);
    TBUtils.print(pen, block1);
    
    block.setContents("Goodbye");
    TextBlock block2 = new BlockPair(block);
    TBUtils.print(pen, block2);
    
    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt
