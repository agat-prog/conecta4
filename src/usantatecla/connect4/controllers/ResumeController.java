package usantatecla.connect4.controllers;

import usantatecla.connect4.models.Session;

public class ResumeController extends Controller implements AcceptorController{


    public ResumeController(Session session) {
		super(session);
	}

	public void reset() {
        this.session.reset();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

	@Override
	public boolean isNull() {
		return false;
	}
}
