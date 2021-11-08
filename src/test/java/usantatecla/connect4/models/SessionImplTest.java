package usantatecla.connect4.models;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import usantatecla.connect4.types.Color;
import usantatecla.utils.models.ConcreteCoordinate;

public class SessionImplTest {

	@InjectMocks
	private SessionImpl sessionImpl;
	
	@Mock
	private State state;
	@Mock
	private Game game;
	@Mock
	private Registry registry;
	
	@BeforeEach
	public void setup() {
		initMocks(this);
	}
	
	@Test
	public void testGivenNewSessionImplWhenNextStateThenStateIsIN_GAME() {
		SessionImpl sessionImpl = new SessionImpl();
		assertThat(sessionImpl.getStateValue(), is(StateValue.INITIAL));
		sessionImpl.nextState();
		assertThat(sessionImpl.getStateValue(), is(StateValue.IN_GAME));
	}
	
	@Test
	public void testGivenSessionImplWhenNextStateIsEXITThenStateIsIN_GAME() {
		SessionImpl sessionImpl = new SessionImpl();
		assertThat(sessionImpl.getStateValue(), is(StateValue.INITIAL));
		sessionImpl.nextState();
		assertThat(sessionImpl.getStateValue(), is(StateValue.IN_GAME));
		sessionImpl.nextState();
		assertThat(sessionImpl.getStateValue(), is(StateValue.RESUME));
		sessionImpl.nextState();
		assertThat(sessionImpl.getStateValue(), is(StateValue.EXIT));
		Assertions.assertThrows(AssertionError.class, () -> {
			this.sessionImpl.nextState();
		});
		/*when(this.sessionImpl.getStateValue()).thenReturn(StateValue.EXIT);
		assertThat(this.sessionImpl.getStateValue(), is(StateValue.EXIT));
		Assertions.assertThrows(AssertionError.class, () -> {
			this.sessionImpl.nextState();
		});*/
	}
	
	@Test
	public void testGivenSessionImplWhenUndoableThenIsTrue() {
		when(this.registry.undoable()).thenReturn(true);
		assertThat(this.sessionImpl.undoable(), is(true));
		verify(this.registry).undoable();
	}
	
	@Test
	public void testGivenSessionImplWhenRedoableThenIsTrue() {
		when(this.registry.redoable()).thenReturn(true);
		assertThat(this.sessionImpl.redoable(), is(true));
		verify(this.registry).redoable();
	}
	
	@Test
	public void testGivenSessionImplWhenResetThenIsTrue() {
		SessionImpl sessionImpl = new SessionImpl();
		assertThat(sessionImpl.getStateValue(), is(StateValue.INITIAL));
		sessionImpl.nextState();
		assertThat(sessionImpl.getStateValue(), is(StateValue.IN_GAME));
		sessionImpl.reset();
		assertThat(sessionImpl.getStateValue(), is(StateValue.INITIAL));
	}
	
	@Test
	public void testGivenSessionImplWhenGetActiveColorThenIsColorRED() {
		when(this.game.getActiveColor()).thenReturn(Color.RED);
		assertThat(this.sessionImpl.getActiveColor(), is(Color.RED));
		verify(this.game).getActiveColor();
	}
	
	@Test
	public void testGivenSessionImplWhenGetActiveColorThenIsColorYELLOW() {
		when(this.game.getActiveColor()).thenReturn(Color.YELLOW);
		assertThat(this.sessionImpl.getActiveColor(), is(Color.YELLOW));
		verify(this.game).getActiveColor();
	}
	
	@Test
	public void testGivenSessionImplWhenIsConnect4ThenIsTrue() {
		when(this.game.isConnect4()).thenReturn(true);
		assertThat(this.sessionImpl.isConect4(), is(true));
		verify(this.game).isConnect4();
	}
}
