package com.everymatrix.rockpaperscissors;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ActionsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void should_Beat_Its_Weak_Action() {
		
		assertTrue(Actions.ROCK.beatsTo(Actions.SCISSORS));
	}
	
	@Test
	public void should_Not_Beat_Its_Strong_Action() {
		
		assertFalse(Actions.ROCK.beatsTo(Actions.PAPER));
	}

}
