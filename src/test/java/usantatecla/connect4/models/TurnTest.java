package usantatecla.connect4.models;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.BaseMatcher.*;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import usantatecla.connect4.types.Color;

public class TurnTest {

	private Turn turn;
	
	@BeforeEach 
	public void init() {
		this.turn = new Turn(new Board());
	}
	
	@Test
	public void givenNewTurnWhenResetThenGetActiveColorIs0() {
		this.turn.next();
		this.turn.reset();
		assertThat(this.turn.getActiveColor(), is(Color.RED));
	}
	
	@Test
	public void givenNewTurnWhenNextThenGetActiveColorIs1() {
		this.turn.next();
		assertThat(this.turn.getActiveColor(), is(Color.YELLOW));
	}
	
}
