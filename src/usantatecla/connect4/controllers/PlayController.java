package usantatecla.connect4.controllers;

import usantatecla.connect4.models.Session;
import usantatecla.connect4.types.Color;
import usantatecla.connect4.types.Error;

public class PlayController extends Controller implements AcceptorController{

	private ActionController actionController;
    private UndoController undoController;
    private RedoController redoController;
	
    public PlayController(Session session) {
        super(session);
        this.actionController = new ActionController(session);
        this.undoController = new UndoController(session);
        this.redoController = new RedoController(session);
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

    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
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
