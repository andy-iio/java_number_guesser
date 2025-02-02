package number_guessing_game;

import java.util.Random;
import java.util.Scanner;

public class game {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
//		introduction
		System.out.println("..........................................");
		System.out.println("Welcome to the guessing game!");
		System.out.println("I'm thinking of a number between 1 and 100");
		System.out.println("You will have to try and guess the number");
		System.out.println("..........................................");

		playGame(scanner);
		
		scanner.close();
	}
		
	public static void playGame(Scanner scanner) {
		int chances = setChances(scanner);
		
//		random number generated for the answer
		Random rand = new Random();
		int max=100, min=1;
		int answer = rand.nextInt(max-min + 1) + min;
//		System.out.println("The answer is " + answer); //debug only line
		
		System.out.println("Lets begin! You have " + chances + " chances");
		
		int guess = 0;
		int attempts = 0;
		boolean win = false;
		
		while (attempts < chances) {
			guess = getUserInput(scanner, 1, 100, "Enter your guess: ");
//			System.out.println("guess:" + guess); //debug only line
			attempts++;
			
			if (guess == answer) {
				win = true;
				break;
			} else {
				giveHint(answer, guess);
			}
		}
		
		endGame(win, attempts, answer);
		
		System.out.println("..........................................");
		System.out.println("Do you want to play again??");
		System.out.println("1. Yes");
		System.out.println("2. No, Exit");
		int choice = getUserInput(scanner, 1, 2, "Please enter your selection: ");
		if (choice == 1) {
			playGame(scanner);
		} else {
			System.out.println("Goodbye!");
		}
	}
	
	
	private static int getUserInput(Scanner scanner, int minOption, int maxOption, String message) {
//		get users input and validate it
		Integer input = null;
		do {
			System.out.println(message);
			String userInput = scanner.nextLine();
			
	        try {
	            input = Integer.valueOf(userInput);
	            //validate input is in range
	            if (input < minOption || input > maxOption) {
	            	System.out.println("Out of range! Please enter a number between " + minOption + " and " + maxOption);
	            	input = null;
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid input.. please try again.");
	        }
		} while (input == null);
		return input;
	}
	
	
	private static int setChances(Scanner scanner) {
//		difficulty level menu
		System.out.println("Select your difficulty level:");
		System.out.println("1 - Easy: 10 Chances");
		System.out.println("2 - Medium: 5 Chances");
		System.out.println("3 - Hard: 3 Chances");
		System.out.println("4 - Impossible: 1 Chance");
		
//		set number of chances 
		int choice = getUserInput(scanner, 1, 4, "Please enter your selection: ");
		int chances = 0;
		switch (choice ) {
			case 1: chances = 10;
				break;
			case 2: chances = 5;
				break;
			case 3: chances = 3;
				break;
			case 4: chances = 1;
				break;
			default: 
				System.out.println("Difficulty selection failed, try again");
		};
		return chances;
	}
	
	// give hint based on users input, if answer is right go to endgame()
	private static void giveHint(int answer, int guess) {
		if (answer < guess) {
			System.out.println("Incorrect! The number is less than " + guess );
		}
		else {
			System.out.println("Incorrect! The number is greater than " + guess );
		}
	}
	
	private static void endGame(Boolean win, int attempts, int answer) {
		System.out.println("..........................................");

		if (win == true) {
			System.out.println("----YOU WIN!!!!!!----");
			System.out.println("You got the answer in " + attempts + " attempts");
		} else {
			System.out.println("-----Out of Attempts-----");
			System.out.println("You Lose... The answer was " + answer);
		}
		
	}
}

