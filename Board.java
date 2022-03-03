/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */
import java.util.Scanner;
import java.io.File;

public class  Board
{
  private String phrase = "";
  private String solvedPhrase = "";
  private int currentLetterValue; 

  /* your code here - constructor(s) */
  public Board() {
    phrase = loadPhrase();
    setLetterValue(); 
}

/* your code here - accessor(s) */
public String getPhrase() {
    return phrase;
}

public String getSolvedPhrase() {
    return solvedPhrase;
}

public int getLetterValue() {
    return currentLetterValue;
}

/* your code here - mutator(s)  */


  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

  private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  
    
    return tempPhrase;
  }  
  /* Return whether or no the guessed letter is found
  * Precondition:
  *   inputted guess
  *   solvedphrase is defined
  * Postcondition:
  *   boolean 
  *   updated solvedPhrase
  */ 
  public boolean guessLetter(String guess) //constructor signature
  {
    boolean foundLetter = false; //initializing foundLetter boolean
    String newSolvedPhrase = ""; //setting string to null
    
    for (int i = 0; i < phrase.length(); i++) //opening for loop
    {
      if (phrase.substring(i, i + 1).equals(guess)) //opening if-else
      {
        newSolvedPhrase += guess + " "; //setting newSolvedPhrase = to itself + the guess and a blank space
        foundLetter = true; //redifining boolean
      }
      else //else statement
      {
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " "; /*setting newSolvedPhrase = to itself + a 
        substring of solvedPhrase that depends on the loop iteration*/ 
      }
    } //close of for loop
    solvedPhrase = newSolvedPhrase; //redefining solvedPhrase
    return foundLetter; //returning boolean
  } 
} 