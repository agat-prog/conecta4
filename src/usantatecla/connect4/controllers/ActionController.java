package usantatecla.connect4.controllers;

import usantatecla.connect4.models.Session;
import usantatecla.connect4.models.SessionImpl;
import usantatecla.connect4.types.Color;
import usantatecla.connect4.types.Error;

public class ActionController extends Controller{

	private SessionImpl sessionImpl;
	
	public ActionController(Session session) {
		super(session);
		this.sessionImpl = ((SessionImpl) this.session);
	}

	public boolean isConnect4() {
		return this.sessionImpl.isConect4();
	}

	public void next() {
        this.sessionImpl.next();
    }
	
	public void nextState() {
        this.sessionImpl.nextState();
    }

	public Color getActiveColor() {
		return this.sessionImpl.getActiveColor();
	}

	public void putToken(int column) {
		this.sessionImpl.putToken(column);
		
	}

	public Error getPutTokenError(int column) {
		return this.sessionImpl.getPutTokenError(column);
	}
}
