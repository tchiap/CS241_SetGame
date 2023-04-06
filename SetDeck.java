/**
 * Tom Chiapete
 * December 15, 2005
 * 
 * SetDeck Class
 * 
 * Sets up a deck.
 * Also has methods to see if it's empty, and has a method 
 * to shuffle the deck.
 * 
 * Known bugs:
 * I'm not quite sure if the deck is being set up correctly.
 * I was told we could set up the deck array using one for loop, 
 * that for loop being controlled by the size of the array.
 * Mathematically, I figured out some equations to accomplish this 
 * so I can get the correct number or numbers, shapes, colors, and shading.
 */


public class SetDeck
{
    // Instance variables
    private SetCard [] deck; // Array of SetCard objects declaration
    private int top; // Holds the current top card

    /**
     * SetDeck() default constructor
     */
    public SetDeck()
    {
        // Initialize array to SetCard objects
        deck = new SetCard [81];
        
        // Sets the top to 0
        top = 0;

        // Instead of using a bunch of for loops,
        // somebody in class told me that I could just use div and mod
        // operations to do the math for me, and just be dependent on 
        // the one x value.
        for(int x=0; x< 81; x++)
        {
            // To find the number, find the remainder of x divided by 3.
            int whichNumber = x%3;
            
            // We need 9 oval, 9 squiggle, and 9 diamond.
            // To find the symbol we would like, we could divide
            // x by 3, and take that value and find the value of 
            // the remainder when we divide it that value by 3.
            // Use whichSymbol as the index.
            int whichSymbol = (x/3) % 3;
            
            // Find the color.  We need 27 of each color.
            // Divide x by 27 to find the integer value of that
            // to be used as the index.
            int whichColor = x/27;
            
            // For each shading, I think this can be calculated by
            // taking the value of when you divide x by 9, and taking 
            // that value modulus 3.
            
            int whichShading = (x/9) % 3;
            
            // Start setting this deck.
            // Follow constructor format.
            deck[x] = new SetCard(
                SetCard.colors[whichColor],SetCard.shadings[whichShading], 
                SetCard.numbers[whichNumber],SetCard.symbols[whichSymbol]
                );
        }
    }

    /**
     * isEmpty() method
     * Checks to see if the top is greater than 80.
     * If that's true, return true.  Else, return false.
     */
    public boolean isEmpty()
    {
        if(top > 80)
            return true;
            
        // Isn't empty, return false
        return false;
    }
    
    
    /**
     * shuffle() method
     * Find a random integer, and use that integer as an index.
     * Create a SetCard temp variable to store the current position 
     * in the deck array.
     */
    public void shuffle()
    {
        for( int x = 0; x< 81; x++ )
        {
            // Generate random integer
            int random = (int)(Math.random()*81);
            
            // Create a SetCard temp variable
            SetCard temp = deck[x];
            
            // Shuffle them... set value of the deck array at 'random'
            // index to the current x value of the deck
            deck[x] = deck[random];
            
            // Put the SetCard we have into the deck array at
            // the random index
            deck[random] = temp;
        }
    }

    /**
     * dealTopCard() method
     * Return the value of the deck array at index top.
     * Increment top.
     * Statement provided from assignment description.
     */
    public SetCard dealTopCard()
    {
        // Return and increment
        return deck[top++];
    }


}







