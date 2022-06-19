package com.everymatrix.rockpaperscissors;

/**
 * Different possibles actions in a rock, paper and scissors game.
 * Each of them implements a method to know against which other action wins.
 * @author Daniel Terol
 *
 */
public enum Actions {
	
	ROCK {
		@Override
		public boolean beatsTo(Actions option) {
			return option == Actions.SCISSORS;
		}
	},
	PAPER {
		@Override
		public boolean beatsTo(Actions option) {
			return option == Actions.ROCK;
		}
	},
	SCISSORS {
		@Override
		public boolean beatsTo(Actions option) {
			return option == Actions.PAPER;
		}
	};
	
	public abstract boolean beatsTo(Actions option);
	
}
