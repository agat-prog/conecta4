package usantatecla.connect4.controllers.implementation;

import usantatecla.connect4.controllers.PlayController;
import usantatecla.connect4.models.Session;

public class PlayControllerImpl extends PlayController{

	public PlayControllerImpl(Session session) {
		// TODO Auto-generated constructor stub
	}

	private ActionController actionController;
    private UndoController undoController;
    private RedoController redoController;
	
    public PlayController(Session session) {
        super(session);
    }

	public boolean isConnect4() {
        return this.actionController.isConnect4();
    }

    public void next() {
        this.actionController.next();
    }

    public Color getActiveColor() {
        return this.actionController.getActiveColor();
    }

    public void putToken(int column) {
        this.actionController.putToken(column);
    }

    public Error getPutTokenError(int column) {
        return this.actionController.getPutTokenError(column);
    }

    public void undo(){
        this.undoController.undo();
    }

    public boolean undoable(){
        return this.undoController.undoable();
    }


    public boolean redoable(){
        return this.redoController.redoable();
    }

	public void redo() {
		this.redoController.redo();
	}

	@Override
	public boolean isNull() {
		return false;
	}
}
