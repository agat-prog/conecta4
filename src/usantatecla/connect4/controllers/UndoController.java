package usantatecla.connect4.controllers;

import usantatecla.connect4.models.Session;
import usantatecla.connect4.models.SessionImpl;

public class UndoController extends Controller{

	public SessionImpl sessionImpl;
	
	public UndoController(Session session) {
		super(session);
		this.sessionImpl = ((SessionImpl) this.session);
	}
	
	public void undo() {
		this.sessionImpl.undo();
	}
	
	public boolean undoable() {
		return this.sessionImpl.undoable();
	}
}
