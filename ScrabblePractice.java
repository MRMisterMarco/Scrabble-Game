// Import necessary classes.
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;                    

/**
 * Write a description of class ScrabblePractice here.
 * 

 */
public class ScrabblePractice 
{
    public static void main(String [] args)  
                        throws FileNotFoundException {
     // Set things up.   
            Scanner keyboard = new Scanner(System.in);  // Create a keyboard scanner.
            System.out.println("\f");   // Clear the screen.   
   
            ArrayList<Tile> player1rack = new ArrayList<Tile>();

     //****** Prob 1 -- add 5 tiles to player1rack:  A/1, A/1, B/3, T/1, X/8 
            Tile practice = new Tile('A', 1);
            
            player1rack.add(practice);
            player1rack.add(practice);
            
            practice = new Tile('B', 3);
            player1rack.add(practice);
            
            player1rack.add(new Tile('T', 1));
            
            player1rack.add(new Tile('X', 8));
     
     System.out.print("player1rack = ");
     printAllTiles(player1rack); 
     //******************************* end Prob 1 ***/
     //****** Prob 2a -- determine if the letter A is in player1rack
     //                  write a for loop and print "found an A" whenever
     //                    you find a Tile that has an A in it
            for(int k = 0; k < player1rack.size(); k++)
            {
                if(player1rack.get(k).getLetter() == 'A')
                {
                        System.out.println("Found an A in player1rack at position "+ k);
                }
            }
     
     //       Prob 2b-- compute and print the sum of all the values
     //                 of the Tiles in player1rack
     //                    use a for loop to add to sum the value of each Tile
     int sum = 0;
            for(int k = 0; k < player1rack.size(); k++)
            {
                   //add the value of tile k to sum
                   sum += player1rack.get(k).getValue();
            }
            
            
     System.out.println("The total score of all tiles is " + sum);
     
     //******************************* end Prob 2 ***/
     //****** Prob 3 -- make a String out of all the Tiles in player1rack
     String rack1Letters = "ABXAT";
     String player1rackTiles = player1rack.toString();
     // make a for loop, get each Tile from player1rack, 
     //                  get the Letter from the Tile (you can chain these with .'s)
     //                  and add it to the end of rack1Letters
        for (int k = 0; k < player1rack.size(); k++)
        {
  
            System.out.println( rack1Letters + player1rack.get(k).getLetter() ); //
        }
     
     //******************************* end Prob 3 ***/
     //****** Prob 4 --  print the count of the number of A's in "ABRAXAS"
     //                  use the countLetters method defined below main 
     //                  then determine if the number of A's in rack1Letters is 
     //                  larger than the number of A's in "ABRAXAS"
     //     
     String word1 = "ABRAXAS";
     
     //countLetters("ABRAXAS", 'A');
     countLetters(word1, 'A');
     int score1 = countLetters(word1, 'A');
 
    
     System.out.println("The number of A's in word1 = " + score1);  // finish this
     
     rack1Letters = "ABXAT";
     countLetters(rack1Letters,'A');
     
     int score2 = countLetters(rack1Letters,'A');
     //                  then determine if the number of A's in rack1Letters is 
     //                  larger than the number of A's in "ABRAXAS"
     if (score1 > score2)
     {
         System.out.println("word1 has more letter A's then rack1Letters");
     }
     else
     {
         System.out.println("Rack1Letters has more letter A's then word1");
     }
     
     
     
     //******************************* end Prob 4 ***/
     //****** Prob 5 -- make a for loop to traverse across all the letters in word1
     //                     store each letter in a char letter variable
     //                     if the count of this letter in word1 is larger 
     //                        than the count of this letter in rack1Letters
     //                          print ("not enough of letter " + letter)
     
     //int word1count = 0;
     //int rack1LettersCount = 0;
            for (int k = 0; k < word1.length(); k++)
            {
                char a = word1.charAt(k);
                //char a = word1.get(k);
                //word1count++;
                countLetters(word1, a);
                int first = countLetters(word1, a);
                
                //for (int i = 0; i < rack1Letters.length(); i++ )
                ////{
                   // char b =  rack1Letters.charAt(k);
                    //countLetters(rack1Letters,b);
                    //int second = countLetters(rack1Letters,b);
                  //  if (a == b && first > second)
                   // {
                   //     System.out.println("Not enough of letter " + a);
                    //}
                //}
                //rack1LettersCount++;
                //if (word1count > rack1LettersCount)
                //{
                  //  System.out.println("Not enough of letter " + letter);
                //}
                if (countLetters(word1, a) > countLetters(rack1Letters, a))
                {
                    System.out.println("Not enough of letter " + a);
                }
                
            }
                
     //word1 = "ALABAMA";
     //player1rack = [A/1,B/3, X/8, A/1, T/2 ];
     //extract all the letters in player1rack put in a string
     //rack1letters = "ABXAT";
     //countLetters(word1, 'A') returns 4
     //but if I say countLetters(rack1letters, 'A') this returns 2
     
      //for (int k = 0; k < word1.length();k++)
      //{
      //    char letter = word1.charAt(k);
      //    int otherScore1 = countLetters("ABRAXAS", letter);
      //    for (int i = 0; i < rack1Letters.length(); i++)
       //   {
         //      char otherLetter = rack1Letters.charAt(i);
         //       int otherScore2 =  countLetters("", otherLetter);
         //       if(otherScore1 > otherScore2)
         //       {
         //           System.out.println("Not enough of letter" + letter);
         //       }
                
         //   }
            
            
       // }
     //******************************* end Prob 5 ***/
     /****** Prob 6 -- use the above ideas to finish the validWord method below main
     //                     
     
     System.out.println("Player 1, please enter a word from the letters in  your rack");
     word1 = keyboard.next();
     
     if  (validWord(word1, player1rack)) {
         System.out.println("Your word is a valid word");
     }
     else {   
         System.out.println("The word you chose doesn't work with your rack.");   
     }    

     //******************************* end Prob 6 ***/
     /****** Prob 7 -- finish and test the scoreOfLetter method below main
     //                     
     System.out.println("The score of letter A is " + scoreOfLetter('A',player1rack));
     System.out.println("The score of letter X is " + scoreOfLetter('X',player1rack));
     
     

     //******************************* end Prob 7 ***/
     /****** Prob 8 -- finish and test the scoreWord method below main
     //                     
     System.out.println("The score of BAT is " + scoreWord("BAT",player1rack));
     System.out.println("The score of TAX is " + scoreWord("TAX",player1rack));

     //******************************* end Prob 8 ***/
     /****** Prob 9 -- Write a method to read in the scrabbleWords file 
     //                 into dictionary ArrayList 
     //                 similar to fillBag in ScrabbleGame but simpler
     
     ArrayList<String> dictionary = new ArrayList<String>();
     // readDictionary(dictionary);
     
     //******************************* end Prob 9 ***/
     /****** Prob 10 -- write a method that returns true if a word is found in the dictionary 
     //             
     
     // System.out.println("Is TAX a legal word in Scrabble? " + isLegal("TAX",dictionary));
     // System.out.println("Is ABRAXAS a legal word in Scrabble? " + isLegal("ABRAXAS",dictionary));
     //******************************* end Prob 10 ***/
     // CONGRATULATIONS! You now have the tools to go out and write a scrabble game!
    }   // END OF MAIN METHOD
    
    public static boolean isLegal(String wordTyped,ArrayList<String> dictionary )
    throws FileNotFoundException
    {
        //wordTyped = new Scanner(System.in);
       //String word = wordTyped;
            for (String word : dictionary)
            {
                if (word.toUpperCase().equals(wordTyped))
                {
                    return true;
                }
            }
            return false;
    }
    
    
    public static void readDictionary(ArrayList<String> dictionary)
                                            throws FileNotFoundException {  
        // Make a Scanner inputFile and connect to file cards.txt.
                Scanner inputFile = new Scanner(new File("scrabbleWords.txt"));
                
                dictionary = new ArrayList<String>();
                while (inputFile.hasNext())
                {
                    dictionary.add(inputFile.next());
                }
               
    } 
    
    public static int countLetters(String s, char c)
    {
        int index = 0, count = 0;
        while (index < s.length()) {
          if (s.charAt(index) == c) {
            count++;
          }
          index++;
        }
        return count;
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
        // Basic Idea: use countLetters defined above to count the number of
        //  a particular letter in word and compare to the number of same
        //  letter in your rack to make sure your rack has enough letters for word
        //  to be constructed from it. If it does (for all letters in word) then
        //  it's a valid word. if not enough for any letter -- invalid.
        
        // First, make a String, rackString, which has all the letters 
        // in the rack.
        
        // Then, make a for loop that goes through all the letters in 
        // String word.
        
        // If ever you find a letter in word that has a count higher
        // than the same letter in rackString, return false.
        //  (use countLetters to determine the count of each letter in word and rackString)
        
        // After your for loop finishes, return true--you got through
        // the loop withouth leaving, so there must be enough letters
        // in rack to allow you to choose word.        
                return true;   // Remove after completing above.                
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
        return -1000; // return -1000 if the letter is not found, signals an error
    } 
    
    // Determines the score of a word and utilizes the "scoreOfLetter" method 
    //  in doing so.
    public static int scoreWord(String word, ArrayList<Tile> rack)
    {
        // Keep track of the score with this variable.
           int score = 0;
                
        // Write a "for" loop that steps k to access every letter of word.
            for(int k = 0; k < word.length();k++)
            {
                word.charAt(k);
                // Add to score the scoreOfLetter of word.charAt(k) in the rack
                score += scoreOfLetter(word.charAt(k), rack);
            }
            
    
        return score;                
    }     
}