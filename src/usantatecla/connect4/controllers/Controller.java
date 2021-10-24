package usantatecla.connect4.controllers;

import usantatecla.connect4.models.Session;
import usantatecla.connect4.models.StateValue;
import usantatecla.connect4.types.Color;
import usantatecla.utils.models.Coordinate;

public abstract class Controller {

    protected Session session;
    
    Controller(Session session) {
        this.session = session;
    }

    public StateValue getValueState() {
		return this.session.getValueState();
	}
    
    public Color getColor(Coordinate coordinate) {
        return this.session.getColor(coordinate);
    }
}
