package usantatecla.connect4.models;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import usantatecla.connect4.types.Color;
import usantatecla.utils.models.ConcreteCoordinate;

public class GameTest {

	private GameBuilder gameBuilder;
	
	@BeforeEach
	public void setup() {
		this.gameBuilder = new GameBuilder();
	}
	
	@Test
	public void testGivenBoardWhenPutTokenThenIsColorYellow() {
		Game game = this.gameBuilder.rows(
				"Y      ",
				"R      ",
				"R      ",
				"R      ",
				"YYRY   ",
				"YRRRYRY").build();
		game.putToken(3);
		assertThat(game.getColor(new ConcreteCoordinate(2,2)), is(Color.YELLOW));
	}
	
	@Test
	public void testGivenBoardWhenPutTokenThenIsColorRed() {
		Game game = this.gameBuilder.rows(
				"Y      ",
				"R      ",
				"R      ",
				"R Y    ",
				"YYRY   ",
				"YRRRYRY").build();
		game.putToken(3);
		assertThat(game.getColor(new ConcreteCoordinate(3,2)), is(Color.RED));
	}
	
	@Test
	public void testGivenBoardWhenPutTokenFullColumnThenPutTokenErrorNotNull() {
		Game game = this.gameBuilder.rows(
				"Y      ",
				"R      ",
				"R      ",
				"R Y    ",
				"YYRY   ",
				"YRRRYRY").build();
		assertFalse(game.getPutTokenError(1).isNull());
	}
}
