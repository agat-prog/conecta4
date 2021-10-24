package usantatecla.connect4.controllers.implementartion;

import usantatecla.connect4.controllers.ActionController;
import usantatecla.connect4.controllers.PlayController;
import usantatecla.connect4.controllers.RedoController;
import usantatecla.connect4.controllers.UndoController;
import usantatecla.connect4.models.Session;
import usantatecla.connect4.types.Color;
import usantatecla.connect4.types.Error;

public class PlayControllerImpl extends PlayController{

	private ActionController actionController;
    private UndoController undoController;
    private RedoController redoController;

    public PlayControllerImpl(Session session) {
		super(session);
		this.actionController= new ActionController(this.session);
		this.undoController= new UndoController(this.session);
		this.redoController= new RedoController(this.session);
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
