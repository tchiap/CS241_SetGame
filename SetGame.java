/**
 * Tom Chiapete
 * December 15, 2005
 * 
 * SetGame Class
 * 
 * Set up the board by creating a SetCard array object.
 * Set up the deck, shuffle, print out the deck.
 * There are methods to find a set or to find if it is a set.
 * 
 * Known bugs:
 * I couldn't find any, but as complex as this project is, I wouldn't 
 * be surprised if there was one or two.
 */

public class SetGame
{

    /** 
     * main() method
     * This is our main execution point.
     * Set up a new board and deck, shuffle it, print out the deck,
     * find the sets.
     */
    public static void main(String [] args)
    {
        SetCard board[] = new SetCard[12]; // Declares and initializes a new SetCard
                                            // array called board, size 12
        SetDeck deck = new SetDeck(); // Declare and initialize a new SetDeck object.
        
        // Shuffle the deck before we start.
        deck.shuffle();

        // Crawl through this loop and deal the top card
        for(int x = 0; x < 12; x++ )
        {
            board[x] = deck.dealTopCard();
        }

        // Start printing out the table.
        System.out.println("---The Set Game---");
        System.out.println( "Game Board:" );
        System.out.println("-----------------------------------------------");
        System.out.println("#    Color     Shading  Number   Shape      ");
        
    
        // Print out the table for every value of x in the board array.
        // Use the format method in the 
        // Use d for integers, s for strings.
        String temp = "";  // temp String
        for(int x=0; x<board.length; x++)
        {
            // The %3d prints out our current x
            // The %s prints out the current value of the board array.
            temp = String.format("%3d %s", x, board[x].toString());
            System.out.println(temp);
        }
        
        System.out.println();
        System.out.println();
        
        // Print out the sets.
        System.out.println("####################################");
        System.out.println("Sets were found at:");

        // Calls the findSets() method.
        findSets(board);
        
        // -- end
    }
    
    /**
     * isSet() method
     * This will compare the three cards in the paramters to check 
     * to see if there is the same shadings, colors, quantities of symbols,
     * and shapes of symbols.
     * 
     * Logically figure out which ones are true.
     * 
     * This method is only true if all four "has" booleans are true.
     */
    public static boolean isSet(SetCard card1, SetCard card2, SetCard card3)
    {
        boolean result;  // Holds the value of the return statement.
        // Checks to see if the cards have the same shading.
        boolean hasSameShadings = (card1.getShading() == card2.getShading() && 
            card1.getShading() == card3.getShading() || card1.getShading() != card2.getShading() && 
            card1.getShading() != card3.getShading() && card2.getShading() != card3.getShading());

        // Checks to see if the cards have the same colors.
        boolean hasSameColors = (card1.getColor() == card2.getColor() && 
            card1.getColor() == card3.getColor() || card1.getColor() != card2.getColor() && 
            card1.getColor() != card3.getColor() && card2.getColor() != card3.getColor());

        // Checks to see if the cards have the same numbers
        boolean hasSameNumbers = (card1.getNumber() == card2.getNumber() && 
            card1.getNumber() == card3.getNumber() || card1.getNumber() != card2.getNumber() && 
            card1.getNumber() != card3.getNumber() && card2.getNumber() != card3.getNumber());
            
        boolean hasSameSymbols = (card1.getSymbol() == card2.getSymbol() && 
            card1.getSymbol() == card3.getSymbol() || card1.getSymbol() != card2.getSymbol() && 
            card1.getSymbol() != card3.getSymbol() && card2.getSymbol() != card3.getSymbol());

        // Checks to see whether or not it is a set.  All have to be true to return true.
        result = (hasSameColors) && (hasSameShadings)  
            && (hasSameSymbols) && (hasSameNumbers);
            
        // Finally, return the result.
        return result;
    }
    
    /**
     * findSets() moethod
     * 
     * I couldn't find any easier way to do this that didn't require 3 loops to check 
     * all valid values of x, y, and z to check to see if we had a set.
     * As far as I know, it works.
     */
    public static void findSets(SetCard [] board)
    {
        // Counter to see how many sets we have.
        int counter = 0;
        
        // Crawl through each value of x, y, z.  
        // For the y, the condition is one below the board length, otherwise 
        // it doesn't look like it works.
        // For z, the condition must be two below the board length,
        // otherwise, it logically wouldn't work.
        for(int x= 0; x <board.length-2; x++)
        {
            for(int y = x+1; y <board.length-1; y++)
            {
                for(int z = y+1;z<board.length; z++)
                {
                    // Checks to see if this is actually a set
                    // If so, print it out.
                    if(isSet(board[x],board[y],board[z]) == true)
                    {
                        // We got one, print it out.
                        System.out.println("FOUND: " + x + ", " + y + ", " + z );
                        counter++; // increment the counter past zero.
                    }
                } // -- end of z for
            } // -- end of y for
        } // -- end of x for
        
        // If there are no sets, let the user know.
        if(counter == 0)
        {
            System.out.println("Could not find any sets.");   
        }
    }
}









