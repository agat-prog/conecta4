package usantatecla.connect4.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import usantatecla.connect4.controllers.PlayController;
import usantatecla.connect4.types.Error;
import usantatecla.utils.views.Console;

public class PlayerViewTest {

	@InjectMocks
	private PlayerView playerView;
	
	@Mock
	private PlayController playController;
	
	@Mock
	private Console console;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testGivenColumnWhenIsNoCompleteThenPutToken() {
		try (MockedStatic<Console> console = Mockito.mockStatic(Console.class)) {
			Mockito.when(this.console.readInt(Mockito.anyString())).thenReturn(1);
			console.when(() -> Console.getInstance()).thenReturn(this.console);
			Mockito.when(this.playController.getPutTokenError(1)).thenReturn(Error.NULL);	
			
			this.playerView.interact();
			Mockito.verify(this.playController, Mockito.times(1)).putToken(Mockito.anyInt());
		}
	}
	
	@Test
	public void testGivenColumnWhenIsCompleteThenPutToken() {
		try (MockedStatic<Console> console = Mockito.mockStatic(Console.class)) {
			Mockito.when(this.console.readInt(Mockito.anyString())).thenReturn(1);
			console.when(() -> Console.getInstance()).thenReturn(this.console);
			Mockito.when(this.playController.getPutTokenError(Mockito.anyInt())).thenReturn(Error.NOT_EMPTY, Error.NULL);	
			this.playerView.interact();
			Mockito.verify(this.playController, Mockito.times(1)).putToken(Mockito.anyInt());
		}
	}
}
