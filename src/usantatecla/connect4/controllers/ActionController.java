package usantatecla.connect4.controllers;

import usantatecla.connect4.models.Session;
import usantatecla.connect4.types.Color;
import usantatecla.connect4.types.Error;

public class ActionController extends Controller{

	ActionController(Session session) {
		super(session);
	}

	public boolean isConnect4() {
		return this.session.isConect4();
	}

	public void next() {
        this.session.next();
    }

	public Color getActiveColor() {
		return this.session.getActiveColor();
	}

	public void putToken(int column) {
		this.session.putToken(column);
		
	}

	public Error getPutTokenError(int column) {
		return this.session.getPutTokenError(column);
	}
}
