package com.everymatrix.rockpaperscissors.main;

import java.util.Scanner;

import com.everymatrix.rockpaperscissors.GameLogic;

/**
 * Game management.
 * @author Daniel Terol
 *
 */
public class Game {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("There are two modes: Fair and Unfair. Please choose one:");
		String mode = sc.nextLine().toLowerCase();
		
		//In case the input is not valid, request it again.
		while(!mode.equals("fair") && !mode.equals("unfair")) {
			System.out.println("Invalid input, please write fair or unfair: ");
			mode = sc.nextLine();	
		}
		
		GameLogic logic = new GameLogic(mode);
		
		//Starts the game depending on the mode selected.
		logic.startGame();
		
		System.out.println(logic.showResults());
		
		

	}

}

	