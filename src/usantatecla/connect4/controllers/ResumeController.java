package usantatecla.connect4.controllers;

import usantatecla.connect4.models.Session;

public abstract class ResumeController extends AcceptorController{


    public ResumeController(Session session) {
		super(session);
	}

	public abstract void resume(boolean resume);
	
    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

	@Override
	public boolean isNull() {
		return false;
	}
}
