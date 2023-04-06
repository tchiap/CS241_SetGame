/**
 * Tom Chiapete
 * December 15, 2005
 * 
 * SetCard Class
 * 
 * Sets the card.
 * I have 4 arrays that stores the types of colors, quantities, shadings, 
 * and symbols.  I made these public and constant, because I use them 
 * in other classes as well.
 * 
 * Has methods to return the instance values of color, symbol, number, and
 * shading.
 * Has a toString() with formatting to neatly print out our information in 
 * a terminal window.
 * 
 * Known bugs:
 * None.  I think everything is correct in this class.
 */


public class SetCard
{
    
    // Instance variables.
    private String color; // Holds color of card
    private String symbol;  // Holds symbol of card
    private int number; // Holds number of card
    private String shading; // Holds the type of shading of card
    
    // Constants
    // I decided to make these public so it would be much easier 
    // to retrieve these constants in the array
    public static final String colors [] = {"red","green","purple"}; // Holds the 3 colors
    public static final String symbols [] = {"oval","squiggle","diamond"}; // Holds the 3 symbols
    
    // Holds the 3 types of shading
    public static final String shadings [] = {"solid","open","striped"}; 
    public static final int numbers [] = {1,2,3}; // Holds the 3 ints

    /**
     * SetCard() constructor
     * Sets the values of the instance variables.  Sets
     * the numbers, colors, symbols, and shadings arrays.
     */
    public SetCard (String color, String symbol, int number, String shading)
    {
        // Set the parameters to the instance variables
        this.color = color;
        this.symbol = symbol;
        this.number = number;
        this.shading = shading;
        
//         // Sets the number array to the following
//         numbers[0] = 1;
//         numbers[1] = 2;
//         numbers[2] = 3;
//         
//         // Sets the colors array to our three colors
//         // red, green, and purple
//         colors[0] = "red";
//         colors[1] = "green";
//         colors[2] = "purple";
//         
//         // Sets the symbols array to oval, squiggle, and diamond
//         symbols[0] = "oval";
//         symbols[1] = "squiggle";
//         symbols[2] = "diamond";
//         
//         // Sets the colors array to solid, open, and striped
//         shadings[0] = "solid";
//         shadings[1] = "open";
//         shadings[2] = "striped";
    }
    
    /**
     * toString() method
     * Formats a string to be displayed in the terminal.
     * I used the format method to format it to look similar to
     * when the jar file is executed.
     */
    public String toString()
    {
        String result = String.format("%7s %10s %4d %10s", 
            color, symbol, number, shading);
        return result;
    }
    
    /**
     * getNumber() method
     * Returns the number instance variable.
     */
    public int getNumber()
    {
        return number;
    }
    
    /**
     * getColor() method
     * Returns the string in the color instance variable.
     */
    public String getColor()
    {
        return color;
    }
    
    /**
     * getSymbol() method
     * Returns the string in the symbol instance variable.
     */
    public String getSymbol()
    {
        return symbol;
    }
    
    /**
     * getShading() method
     * Returns the string in the shading instance variable.
     */
    public String getShading() 
    {
        return shading;
    }
}
