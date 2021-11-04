package usantatecla.connect4.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import junit.framework.Assert;
import usantatecla.connect4.types.Color;
import usantatecla.utils.models.ConcreteCoordinate;

@RunWith(MockitoJUnitRunner.class)
public class BoardTest {

	public BoardTest() {}
	
	@Test
	public void givenBoardWhenPutTokenThenChangeBoard() {
		Board board = new Board();
		board.putToken(1, Color.RED);
		
		Assert.assertTrue(board.getColor(new ConcreteCoordinate(0, 0)).equals(Color.RED));
	}
}
