package usantatecla.connect4.controllers;

import usantatecla.connect4.models.Session;

public abstract class AcceptorController extends Controller{

	AcceptorController(Session session) {
		super(session);
    }
    
    public abstract boolean isNull();

	public abstract void accept(ControllersVisitor controllerVisitor);
}