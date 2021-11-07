package usantatecla.connect4.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegistryTest {
	
	private RegistryBuilder registryBuilder;
	
	@BeforeEach
	public void setup() {
		this.registryBuilder = new RegistryBuilder();
	}

	@Test
	public void testgivenRegistryWhenInitThenUndoable() {
		assertFalse(this.registryBuilder.build().undoable());
	}
	
	@Test
	public void testgivenRegistryWhenInitThenNoRedoable() {
		assertFalse(this.registryBuilder.build().redoable());
	}
	
	@Test
	public void testgivenRegistryWhenGameNextThenUndoable() {
		Game game = new GameBuilder().build();
		Registry registry = new Registry(game);
		this.putToken(1, game, registry);
		assertTrue(registry.undoable());
	}
	
	@Test
	public void testgivenRegistryWhenUndoThenRedoable() {
		Game game = new GameBuilder().build();
		
		Registry registry = new Registry(game);
		this.putToken(1, game, registry);
		
		registry.undo();
		assertTrue(registry.redoable());
	}
	
	@Test
	public void testgivenRegistryWhenUndoAndRedoThenUndoable() {
		Game game = new GameBuilder().build();
		
		Registry registry = new Registry(game);
		this.putToken(1, game, registry);
		
		registry.undo();
		assertTrue(registry.redoable());
		
		registry.redo();
		assertTrue(registry.undoable());
	}
	
	@Test
	public void testgivenRegistryWhenUndoAndRegisterThenNoRedoable() {
		Game game = new GameBuilder().build();
		
		Registry registry = new Registry(game);
		this.putToken(1, game, registry);
		
		registry.undo();
		assertTrue(registry.redoable());
		
		this.putToken(1, game, registry);
		assertFalse(registry.redoable());
	}
	
	private void putToken(int column, Game game, Registry registry) {
		game.putToken(column);
		game.next();
		registry.register();
	}
}
