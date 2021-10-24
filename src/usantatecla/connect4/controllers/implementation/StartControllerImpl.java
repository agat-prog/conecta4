package usantatecla.connect4.controllers.implementation;

import usantatecla.connect4.controllers.StartController;
import usantatecla.connect4.models.Session;
import usantatecla.connect4.models.SessionImpl;

public class StartControllerImpl extends StartController{

	private SessionImpl sessionImpl;

	public StartControllerImpl(Session session) {
		super(session);
		this.sessionImpl = (SessionImpl) this.session;
	}

	@Override
	public void start() {
		this.sessionImpl.nextState();
	}
}
