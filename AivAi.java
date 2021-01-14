package strategyRPS;

import java.util.Random;
import java.util.Scanner;

public class AivAi {

	// Note: BOT 1 is the one using the strategy
	public static void main(String[] args) {
		int A1score = 0;
		int A1choice = 0;
		int A2score = 0;
		int A2choice = 0;
		int ties = 0;	
		int winner = 0;
		
		// Welcomes user
		System.out.println(welcome());
		
		// Asks user how many rounds are to be played
		System.out.println("How many rounds would you like the AIs to play?");
		Scanner r = new Scanner(System.in);
		int totalrounds = r.nextInt();
		System.out.println();
		
		// Iterates every round to initiate another play
		for (int round = 1; round <= totalrounds; round++) {
			
			// Gets BOT 1's choice
			System.out.println("-------------------ROUND " + round + "-------------------");
			System.out.print("BOT 1: ");
			
			// Use strategy to determine what BOT 1 will pick
			if (winner == 2) {
				if ((A1choice == 1 && A2choice == 2) || (A1choice == 2 && A2choice == 1)) {
					A1choice = 3;
				} else if ((A1choice == 2 && A2choice == 3) || (A1choice == 3 && A2choice == 2)) {
					A1choice = 1;
				} else if ((A1choice == 3 && A2choice == 1) || (A1choice == 1 && A2choice == 3)) {
					A1choice = 2;
				}
			} else if (winner == 1) {
				A1choice = A2choice;
			} else if (winner == 0) {
				A1choice = AIchoice();
			}
			
			if (A1choice == 1) {
				System.out.print("ROCK");
		    } else if (A1choice == 2) {
				System.out.print("PAPER");
	        } else if (A1choice == 3) {
				System.out.print("SCISSORS");
			}


			System.out.println();
			
			// Gets BOT 2's choice
			A2choice = AIchoice();
			System.out.print("BOT 2: ");
			
			if (A2choice == 1) {
				System.out.print("ROCK");
		    } else if (A2choice == 2) {
				System.out.print("PAPER");
	        } else if (A2choice == 3) {
				System.out.print("SCISSORS");
			}
	
			
			// Scoring (Win/Lose/Tie)
			System.out.println("\n");
			
			// Tie:
			if (A1choice == A2choice) {
				System.out.println("TIE!");
				ties++;
				winner = 0;
			} 
			// Win: 
			else if ((A1choice == 1 && A2choice == 3) || (A1choice == 2 && A2choice == 1) || (A1choice == 3 && A2choice == 2)) {
				System.out.println("BOT 1 WINS!");
				A1score++;
				winner = 1;
				
			}
			// Lose:
			else if ((A2choice == 1 && A1choice == 3) || (A2choice == 2 && A1choice == 1) || (A2choice == 3 && A1choice == 2)) {
				System.out.println("BOT 2 WINS!");
				A2score++;
				winner = 2;
			}
			
			System.out.println("---------------------------------------------");
	
			
		}
		
		// Print Score
		System.out.println("\n\n----------------- GAME OVER -----------------\n");
		System.out.println("                  | SCORE: |\n                  |BOT 1: " + A1score + "|\n                  |BOT 2: " + A2score + "|\n                  |TIES:  " + ties + "|");

	}
	
	private static int AIchoice() {
		// Random number from 1 to 3
		Random rand = new Random();
		return rand.nextInt(3) + 1;
	}
	
	private static String welcome() {
		return "~~~~~ Welcome to ROCK, PAPER, SCISSORS! (Strategy Edition) ~~~~~\n";
	}

}
