package usantatecla.connect4.controllers;

import usantatecla.connect4.models.Session;

public class StartController extends Controller implements AcceptorController{

    public StartController(Session session) {
		super(session);
	}

	public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

	@Override
	public boolean isNull() {
		return false;
	}
}
