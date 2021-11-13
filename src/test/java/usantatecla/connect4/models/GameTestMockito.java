package usantatecla.connect4.models;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import usantatecla.connect4.types.Color;
import usantatecla.utils.models.ConcreteCoordinate;

public class GameTestMockito {

	@InjectMocks
	private Game game;
	
	@Mock
	private Board board;
	
	@Mock
	private Turn turn;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testGivenNewGameWhenGetActiveColorThenIsRED() {
		when(turn.getActiveColor()).thenReturn(Color.RED);
		assertThat(this.game.getActiveColor(), is(Color.RED));
		verify(this.turn).getActiveColor();
	}
	
	@Test
	public void testGivenNewGameWhenIsConnect4ThenIsFalse() {
		when(this.board.isConnect4()).thenReturn(false);
		assertThat(this.game.isConnect4(), is(false));
		verify(this.board).isConnect4();
	}
	
	@Test
	public void testGivenGameWhenResetThenBoardIsResetAndTurnIsReset() {
		this.game = new Game();
		this.game.putToken(1);
		assertThat(this.game.getColor(new ConcreteCoordinate(0,0)), is(Color.RED));
		this.game.reset();
		assertThat(this.game.getColor(new ConcreteCoordinate(0,0)), is(Color.NULL));
	}
}
