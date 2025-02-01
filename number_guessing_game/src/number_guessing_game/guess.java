package number_guessing_game;

import java.util.Random;
import java.util.Scanner;

public class guess {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
//		introduction 
		System.out.println("Welcome to the guessing game!");
		System.out.println("I'm thinking of a number between 1 and 100");
		System.out.println("You will have to try and guess the number");

		playGame(scanner);

		
		scanner.close();
	}
	
	
	
	public static int getUserInput(Scanner scanner, int minOption, int maxOption, String message) {
//		get users input and validate it
		Integer input = null;
		do {
			System.out.println(message);
			String userInput = scanner.nextLine();
			System.out.println("you input " + userInput); //debug only line
			
	        try {
	            input = Integer.valueOf(userInput);
	            //validate input is in range
	            if (input < minOption || input > maxOption) {
	            	System.out.println("Out of range! Please enter a number between " + minOption + " and " + maxOption);
	            	input = null;
	            }
	            System.out.println("Converted input: " + input); //debug only line
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid input.. please try again.");
	        }
		} while (input == null);
		return input;
	}
	
	
	public static void playGame(Scanner scanner) {
		int chances = setChances(scanner);
		
//		random number generated for the answer
		Random rand = new Random();
		int max=100, min=1;
		int answer = rand.nextInt(max-min + 1) + min;
		System.out.println("The answer is " + answer); //debug only line
		
		System.out.println("Lets begin! You have " + chances + " chances");
		int guess;
		while (chances > 0) {
			guess = getUserInput(scanner, 1, 100, "Enter your guess: ");
			chances--;
			System.out.println("guess:" + guess); //debug only line
			giveHint(answer, guess);
			
		}
//		check it is between 1 and 100 and only a number
		
//		while guesses < chances 
//		if guess == answer, go to end message
//		if guess > answer, print ans is less than guess msg
//		if guess < answer, print ans more than guess msg
//		guesses ++
//		failed message
	}
	
	public static int setChances(Scanner scanner) {
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
	
	public static void giveHint(int answer, int guess) {
		if (answer == guess) {
			System.out.println("----YOU WIN!!!!!!----");
			endMenu();
		}
		else if (answer < guess) {
			System.out.println(guess + " is too high");
		}
		else {
			System.out.println(guess + " is too low");
		}
	}
	
	public static void endMenu() {
		
	}

}

