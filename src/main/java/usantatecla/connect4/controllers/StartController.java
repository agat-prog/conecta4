package usantatecla.connect4.controllers;

import usantatecla.connect4.models.Session;

public abstract class StartController extends AcceptorController{

    public StartController(Session session) {
		super(session);
	}

	public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

	public abstract void start();
	
	@Override
	public boolean isNull() {
		return false;
	}
}
