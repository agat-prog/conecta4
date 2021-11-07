package usantatecla.connect4.models;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import usantatecla.connect4.types.Color;

public class MementoTest {

	private MementoBuilder mementoBuilder;
	
	@BeforeEach
	public void setup() {
		this.mementoBuilder = new MementoBuilder();
	}
	
	@Test
	public void testgivenMementoWhenCreateThenExistsActivePlayer() {
		assertTrue(this.mementoBuilder.build().getActivePlayer() > 0);
	}
	
	@Test
	public void givenMementoWhenCreateThenBoardIsCopied() {
		Board board = new BoardBuilder().rows(
				"       ",
				"       ",
				"       ",
				"       ",
				"       ",
				"RYRRYYR"
				).build();
		Turn turn = new Turn(board);
		Memento memento = new Memento(board, turn);
		
		assertFalse(board == memento.getBoard());
		assertThat(BoardTest.isSameValues(board, memento.getBoard()), is(true));
	}
	
	@Test
	public void testgivenCreatedMementoWhenGetPutTokensThenTokensNumber() {
		assertTrue(this.mementoBuilder.build().getPlayerPutTokens(Color.RED) == 4);
		assertTrue(this.mementoBuilder.build().getPlayerPutTokens(Color.YELLOW) == 3);
	}
	
	@Test
	public void testgivenCreatedMementoWhenGetPutTokensColorNullThenException() {
		Assertions.assertThrows(AssertionError.class, () -> {
			this.mementoBuilder.build().getPlayerPutTokens(Color.NULL);
		});
	}
}
