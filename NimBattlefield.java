//modified from Douglas Kiang by Bobby Do
//two programs fight by playing the game Nim
import java.util.Scanner;

public class NimBattlefield{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    System.out.println("Welcome to the Nim Battlefield. Choose the starting number of pieces:");
    int startNumPieces = in.nextInt(); // the starting number of pieces
    int pieces = startNumPieces; // the number of pieces
    int p1wins = 0; // number of times player 1 won
    int p2wins = 0; // number of times player 2 won
    int winner = 0; // 1 for player 1 win, 2 for player 2 win
    System.out.println("How many games will you test?");
    int numGames = in.nextInt(); // number of games
    int currentNumGames = 0; // current number of games
    Nim player1 = new Nim(); // PLAYER 1 INITIALIZES - change the name of the class
    NimTing player2 = new NimTing(startNumPieces); // PLAYER 2 INITIALIZES - change the name of the class
    int turn = 0; // 1 means it is player 1's turn, and 2 means it is player 2's turn;
    while (currentNumGames < numGames) {  // plays the specified number of games
      if (Math.random() < 0.5) { // 50 percent chance player 1 or player 2 goes first
        // System.out.println("Player 1 goes first!");
        turn = 1; // player 1 goes first
      }
      else {
        // System.out.println("Player 2 goes first!");
        turn = 2; // player 2 goes first
      }
      while (pieces > 1) { 
        //System.out.println("There are " + pieces + " pieces");
        if (turn == 1) { // if it's player 1's turn
          int p1takes = player1.play(pieces);
          //System.out.println("Player 1 takes " + p1takes);
          pieces -= p1takes; // player 1 takes pieces
          turn = 2; // it is now player 2's turn
          if (pieces == 1) {
            p1wins++; // total number of wins is incremented by 1
            winner = 1; // current winner is now player 1
          }
        }
        else { // if it's player 2's turn
          int p2takes = player2.play(pieces);
          //System.out.println("Player 2 takes " + p1takes);
          pieces -= p2takes; // player 2 takes pieces
          turn = 1; // it is now player 1's turn
          if (pieces == 1) {
            p2wins++; // total number of wins is incremented by 1
            winner = 2; // current winner is now player 2
          }
        }      
      }
      //if (winner == 1) System.out.println("Player 1 wins!!!");
      //else System.out.println("Player 2 wins!!!");
      pieces = startNumPieces; // resets the number of pieces
      currentNumGames++; //increases the number of games completed by one
    }
    System.out.println("Player 1 won " + p1wins + " times.");
    System.out.println("Player 2 won " + p2wins + " times.");
    if (p1wins > p2wins) System.out.println("Player 1 is the winner!");
    else if (p1wins == p2wins) System.out.println("It is a tie!");
    else System.out.println("Player 2 is the winner!");
  }
}