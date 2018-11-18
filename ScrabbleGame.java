// Import necessary objects.
            import java.util.Scanner;
            import java.io.File;
            import java.io.FileNotFoundException;
            import java.util.ArrayList;                    

/**
 * Write a description of class ScrabbleGame here.
 * 
 * @author Rachel Weber
 * @version November 20, 2014
 */
public class ScrabbleGame 
{
    public static void main(String [] args) 
    throws FileNotFoundException {
     // Set things up.   
            Scanner keyboard = new Scanner(System.in);  // Create a keyboard scanner.
            System.out.println("\f");   // Clear the screen.
            ArrayList<Tile> letterBag = new ArrayList<Tile>();   // Array for holding scrabble tiles.
    
     //a) Finish the fillBag method below main. This method fills the letterBag
     //   with info for 99 tiles read from tiles.txt              
            fillBag(letterBag);
            System.out.println("The first letter in letterBag is " + letterBag.get(0));
            System.out.println("The last letter in letterBag is " + letterBag.get(98));
    
     //b) Finish the makeRack method below main. This method creates a rack of 
     //   7 tiles and assigns them 7 random tiles from letterBag.
            ArrayList<Tile> player1rack = makeRack(letterBag);
            ArrayList<Tile> player2rack = makeRack(letterBag);
            
     //c) Add the printAllTiles method below main.
            System.out.print("player 1 rack = "); 
            printAllTiles(player1rack);
            System.out.print("player 2 rack = ");
            printAllTiles(player2rack);
            
            System.out.println("Player 1, please enter a word from the letters in  your rack");
            String word1 = keyboard.next();
    
     //d) CHALLENGE: Finish the validWord method below main. This determines if
     //   the letters in word1 are all found (at the same or greater count) as 
     //   the letters in player1rack. You can go on and come back to this later.
            if (validWord(word1, player1rack)) {
                //e) EASIER CHALLENGE: Finish the scoreWord and scoreOfLetter methods below main.
                //   The scoreWord method steps through each letter in word, finds the corresponding
                //   Tile in the rack, and adds up all the values associated with all the  Tiles 
                //   that make up word.
                
                        int score1 = scoreWord(word1, player1rack);
                        System.out.println("The word you chose has a score of " + score1);
                        
                //f) CHALLENGE: Figure out a way to replace the letters used by word in the rack
                //   with new random letters taken from the letterBag.      
                
                //        replenishRack(word1, player1rack, letterBag);
                //        System.out.print("the new player 1 rack = ");
                //        printAllTiles(player1rack); 
                
            }
            else {   
                System.out.println("The word you chose doesn't work with your rack.");   
            }
            
    }   // END OF MAIN METHOD
           
    // Takes file input to make a bag (array) of Scrabble tiles.  
    public static void fillBag(ArrayList<Tile> tiles)
                                            throws FileNotFoundException {  
        // Make a Scanner inputFile and connect to file cards.txt.
                Scanner inputFile = new Scanner(new File("tiles.txt"));        
        // Counter.        
                int k = 0;                
        // While loop, as long as k < 99 AND there is more info in file.
            while(k < 99 && inputFile.hasNext()) { 
                char letter = inputFile.next().charAt(0);     // Read a char from the file, store in "letter".                  
                int value = inputFile.nextInt();     // Read an int from the file, store in "value".            
                Tile temp = new Tile(letter, value);    // Make a temporary Tile to hold the information.
                tiles.add(temp);    // Add it to the bag of tiles.
                k++;    // Add 1 to k for next time around.
           }        
    }       
    
    // Sets up a rack of random Scrabble tiles.
    public static ArrayList<Tile> makeRack(ArrayList<Tile> tileBag) {
        // Create a Tile ArrayList called rack which will hold 7 tiles.
           ArrayList<Tile> rack = new ArrayList<Tile>();
        
        // Make a for loop that starts with int k=0 and repeats 7 times.
            for(int k = 0; k < 7; k++) {
             // Use the randomInt method to make a  
             // random index from 0 - 99 (exclusive).
                int index = randomInt(0, tileBag.size());
                
             // Store the tile at that random index in tileBag
             // in position k of the rack.
                rack.add(tileBag.get(index));                
             // Make sure the tile that was added to the rack is also removed from the bag.
                tileBag.remove(index);                
            }
           
        // After the for loop, return your filled rack of tiles.                   
                return rack;                
    }    
    
    // Produces a random integer within the given range.
    public static int randomInt(int low, int high) {
        // Determine the length of the range.
                int range = high - low;
      
        // Give a random number from the range.
                return (int)(range*Math.random()) + low;
        
    }   
    
    
    // Prints all the tiles in an array.
    public static void printAllTiles(ArrayList<Tile> tiles) {        
            for (int k = 0; k < tiles.size(); k++) {
                System.out.print(tiles.get(k) + " "); 
            }        
            System.out.println();// Go to new line.                
    }    
    
    
    // This method has not been completed which means the user can cheat by entering 
    //  invalid words.
    public static boolean validWord(String word, ArrayList<Tile> rack)
    {
        // First make a countLetters method below this method
        // that takes a char and a String and returns the number 
        // of times the char value appears in the String. 
        // See exercise 20 in assessment 8 for a solution to countLetters.
        
        // Then, make a String, rackString, which has all the letters 
        // in the rack.
        
        // Then, make a for loop that goes through all the letters in 
        // String word.
        
        // If ever you find a letter in word that has a count higher
        // than the same letter in rackString, return false.
        
        // After your for loop finishes, return true--you got through
        // the loop withouth leaving, so there must be enough letters
        // in rack to allow you to choose word.        
                return true;   // Remove after completing above.                
    }   
    

    // Determines the score of a word and utilizes the "scoreOfLetter" method 
    //  in doing so.
    public static int scoreWord(String word, ArrayList<Tile> rack)
    {
        // Keep track of the score with this variable.
           int score = 0;
                
        // A "for" loop that steps k to access every letter of word.
            for (int k = 0; k < word.length(); k++) {   // Add to score the scoreOfLetter of word.charAt(k) in the rack
                
                score = score + scoreOfLetter(word.charAt(k), rack); // Invoke the scoreOfLetter method which will determine the score of the letter at each index.                
            }       
            return score;                
    }       
    
    
    // Gives back the score of the letter on an individual tile in the rack.
    public static int scoreOfLetter(char letter, ArrayList<Tile> rack) {       
        // Write a for loop that steps k to access every Tile of rack.
        // If the letter matches the letter in the Tile at location k in the rack
        // return the value of the Tile in the rack at location k.
            for(int k = 0; k < rack.size(); k++) {
                if((rack.get(k)).getLetter() == letter) {
                    return (rack.get(k)).getValue();
                }            
            }
                
            return -1000; // After the loop, if we didn't find the letter, 
                          // something is wrong -- invalid word, so return -1000.
                              
    }   
}