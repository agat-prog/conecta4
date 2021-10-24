package usantatecla.connect4.controllers;

import usantatecla.connect4.models.Session;
import usantatecla.connect4.models.SessionImpl;

public class RedoController extends Controller {

	private SessionImpl sessionImpl;
	
	public RedoController(Session session) {
		super(session);
		this.sessionImpl = ((SessionImpl) this.session);
	}

	public void redo() {
		this.sessionImpl.redo();
	}

	public boolean redoable() {
		return this.sessionImpl.redoable();
	}
}
