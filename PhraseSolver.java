/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1;
  private Player player2;
  private Board game;
  private boolean solved;
  
  /* your code here - constructor(s) */
  public PhraseSolver() {
      player1 = new Player();
      player2 = new Player();
      solved = false;
  }    
  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */

  public void play()
  {
    boolean solved = false;
    String currentPlayer = player1.getName();

    Scanner input = new Scanner(System.in);
    
    game = new Board();
    System.out.println(game.getSolvedPhrase());
    String not = "Also aren't in phrase: ";
    String guessed = "Guessed so far: ";
    while (!solved) 
    {
      
      /* your code here - game logic */
      /*
      **-Set the current player to Player 1.
      **-Prompt the current player for a guess. (The player should be able to type a full phrase or a single letter for a guess.)
      **-Check to see if the phrase is solved.
      **-Check to see if the letter is in the phrase.
      **-Stop the game if the phrase is solved.
      **-Switch players if the guess is incorrect, and repeat the above starting at Step 2.
      */
      System.out.println("Please Provide a Guess " + currentPlayer + " (Letter or Full Phrase):" );
      String guess = input.nextLine();
      if (guess.equals(game.getPhrase())){
        System.out.println(currentPlayer + " wins the game!");
        solved = true;
      }
      else if (game.guessLetter(guess)){
        System.out.println(game.getSolvedPhrase());
        //if (game.getSolvedPhrase().equals(game.getPhrase())){
         // System.out.println(currentPlayer + " wins the game!"); couldn't get to work
         // solved = true;
        //}
        guessed = guessed + guess + ", ";
        System.out.println(guessed);
      }
      else {
        System.out.println(guess + " isn't in the phrase!");
        System.out.println(not);
        System.out.println(guessed);
        not = not + guess + ", ";
        if (currentPlayer == player1.getName())
        currentPlayer = player2.getName();
        else 
        currentPlayer = player1.getName();
      }
      /* your code here - determine how game ends */

    } 
   
  }
}