package usantatecla.connect4.controllers;

import usantatecla.connect4.models.Session;
import usantatecla.connect4.types.Color;
import usantatecla.connect4.types.Error;

public abstract class PlayController extends AcceptorController {

    public PlayController(Session session) {
        super(session);
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

	@Override
	public boolean isNull() {
		return false;
	}

	public abstract boolean isConnect4();

    public abstract void next();

    public abstract Color getActiveColor();

    public abstract void putToken(int column);

    public abstract Error getPutTokenError(int column);

    public abstract void undo();

    public abstract boolean undoable();

    public abstract boolean redoable();

	public abstract void redo();

	public abstract void nextState();
}
