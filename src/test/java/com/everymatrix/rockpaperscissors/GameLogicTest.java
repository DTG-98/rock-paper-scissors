package com.everymatrix.rockpaperscissors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class GameLogicTest {

	GameLogic logic;
	
	@Before
	public void setUp() throws Exception {
		
		logic = new GameLogic("fair");
		
	}

	/**
	 * 	After a few random moves, all possible actions (and no more)
	 *  should be added to the set. So set's size and actions possible values
	 *  should matches.
	 */
	@Test
	public void should_Be_Random_Within_The_Possible_Actions() {
		
		Set<Actions> actions = new HashSet<>();

		for (int i = 0; i < GameLogic.getTotalGames(); ++i)
			actions.add(logic.getRandomMove());
		
		assertEquals(actions.size(), Actions.values().length);
	}

	@Test
	public void should_Increment_Count_When_Winning() {
		
		//Player 2 should win in this match so it should increment the count.
		logic.match(Actions.ROCK, Actions.PAPER);
		
		assertEquals(logic.getResults().get(GameLogic.getPlayer2()), Integer.valueOf(1));
	}
	
	@Test
	public void should_Not_Increment_Count_When_Lossing() {
		
		//Player 1 should lose in this match so it shouldn't increment the count.
		logic.match(Actions.ROCK, Actions.PAPER);
		
		assertEquals(logic.getResults().get(GameLogic.getPlayer1()), Integer.valueOf(0));
	}

	@Test
	public void should_Have_Ten_Results_Fair_Mode() {
		
		logic.fairMode();
		
		assertEquals(logic.getResults().entrySet().stream().mapToInt(entry -> entry.getValue()).sum(), GameLogic.getTotalGames());
	}

	@Test
	public void should_Have_Ten_Results_Unfair_Mode() {
		
		logic.unfairMode();
		
		assertEquals(logic.getResults().entrySet().stream().mapToInt(entry -> entry.getValue()).sum(), GameLogic.getTotalGames());
	}

	@Test
	public void should_Show_Results_In_Descending_Order() {
		
		logic.getResults().put(GameLogic.getPlayer1(), 2);
		logic.getResults().put(GameLogic.getDraw(), 3);
		logic.getResults().put(GameLogic.getPlayer2(), 1);
		
		StringBuilder expected = new StringBuilder("\nFINAL RESULTS: \n");
		
		expected.append("Total games played: ").append(GameLogic.getTotalGames()).append("\n");
		
		expected.append("Draw -> 3\n").append("Player 1 -> 2\n").append("Player 2 -> 1\n");
		
		assertTrue(expected.toString().equals(logic.showResults()));
		
		
	}

}
