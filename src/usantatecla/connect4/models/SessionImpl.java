package usantatecla.connect4.models;

public class SessionImpl extends Session{
    private State state;
	private Game game;
	private Registry registry;
	
	public SessionImpl() {
		this.state = new State();
		this.game = new Game();
		this.registry = new Registry(game);
	}
	
	public void reset() {
		this.state.reset();
		this.game.reset();
		this.registry.reset();
	}
	
	public void nextState() {
		this.state.next();
	}
	
	public StateValue getStateValue() {
		return this.state.getValueState();
	}
	
	public boolean undoable() {
		return this.registry.undoable();
	}
	
	public boolean redoable() {
		return this.registry.redoable();
	}
	
	public void undo() {
		this.registry.undo();
	}
	
	public void redo() {
		this.registry.redo();
	}
	
	public void next() {
		this.game.next();
		this.registry.register();
	}
	
	public Color getColor(Coordinate coordinate) {
		return this.game.getColor(coordinate);
	}
	
	public boolean isConect4() {
		return this.game.isConnect4();
	}

	public Color getActiveColor() {
		return this.game.getActiveColor();
	}

	public void putToken(int column) {
		this.game.putToken(column);
	}

	public Error getPutTokenError(int column) {
		return this.game.getPutTokenError(column);
	}

	public Object getValueState() {
		return this.state.getValueState();
	}
}