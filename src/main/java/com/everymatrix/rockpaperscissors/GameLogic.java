package com.everymatrix.rockpaperscissors;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Meant to manage a game of rock, paper and scissors.
 * @author Daniel Terol
 *
 */
public class GameLogic {
	
	private static final int TOTAL_GAMES = 10;
	private static final String PLAYER_1 = "Player 1";
	private static final String PLAYER_2 = "Player 2";
	private static final String DRAW = "Draw";
	
	private Map<String, Integer> results = new HashMap<>();
	
	private String mode;
	
	private Random ran = new Random();
	
	
	public GameLogic(String mode) {
		this.mode = mode;
		
		results.put(DRAW, 0);
		results.put(PLAYER_1, 0);
		results.put(PLAYER_2, 0);
	}
	
	/**
	 * Starts the game depending on the mode selected.
	 */
	public void startGame() {
		
		switch(mode) {
			case("fair"):
				fairMode();
				break;
				
			case("unfair"):
				unfairMode();
				break;
				
			default:
				break;
		}
	}
	
	/**
	 * Gets a random action
	 * @return random action to play.
	 */
	public Actions getRandomMove() {
		int random = ran.nextInt(Actions.values().length);
		
		return Actions.values()[random];
	}
	
	/**
	 * Checks if both actions are equal, so the match is a draw, or
	 * use the method 'beatsTo' to find out which action wins.
	 * It then increments the counter on the map depending on which player 
	 * has won or if it is a draw.
	 * @param player1 is the action to be performed by player 1
	 * @param player2 is the action to be performed by player 2
	 */
	public void match(Actions player1, Actions player2) {
		
		System.out.println("Player 1 move -> " + player1.name());
		System.out.println("Player 2 move -> " + player2.name());
		
		if (player2 == player1) {
			results.put(DRAW, results.get(DRAW) + 1);
			System.out.println("It's a draw");
		}
		else if (player1.beatsTo(player2)) {
			results.put(PLAYER_1, results.get(PLAYER_1) + 1);
			System.out.println("Player 1 wins!");
		}
		else{
			results.put(PLAYER_2, results.get(PLAYER_2) + 1);
			System.out.println("Player 2 wins!");
		}
	}
	
	/**
	 * Game between two players who perform random actions in each round.
	 */
	public void fairMode() {
		
		System.out.println("\nBoth players are random");
		for (int i = 0; i < TOTAL_GAMES; ++i) {
			System.out.println("\nROUND " + (i+1));
			match(getRandomMove(), getRandomMove());
		}
	
	}
	
	/**
	 * Game between two players in which one of them always uses "ROCK".
	 */
	public void unfairMode() {
		
		System.out.println("\nPlayer 1 is random, player 2 is always using rock");
		for (int i = 0; i < TOTAL_GAMES; ++i) {
			System.out.println("\nROUND " + (i+1));
			match(getRandomMove(), Actions.ROCK);
		}
		
	}
	
	/**
	 * Prepares the leaderboard to be shown iterating through the ordered map.
	 * The leaderboard will be displayed starting from the most repeated result to the least repeated result.
	 * @return String containing the leaderboard of the game
	 */
	public String showResults() {
		
		StringBuilder finalResults = new StringBuilder("\nFINAL RESULTS: \n");
		
		finalResults.append("Total games played: ").append(TOTAL_GAMES).append("\n");
		
		results.entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        .forEach(entry -> finalResults.append(entry.getKey()).append(" -> ").append(entry.getValue()).append("\n"));

		
		return finalResults.toString();
	}

	public Map<String, Integer> getResults() {
		return results;
	}

	public void setResults(Map<String, Integer> results) {
		this.results = results;
	}

	public static int getTotalGames() {
		return TOTAL_GAMES;
	}

	public static String getPlayer1() {
		return PLAYER_1;
	}

	public static String getPlayer2() {
		return PLAYER_2;
	}

	public static String getDraw() {
		return DRAW;
	}

}
