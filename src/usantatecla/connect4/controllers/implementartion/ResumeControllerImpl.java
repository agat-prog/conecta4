package usantatecla.connect4.controllers.implementation;

import usantatecla.connect4.controllers.ResumeController;
import usantatecla.connect4.models.Session;
import usantatecla.connect4.models.SessionImpl;

public class ResumeControllerImpl extends ResumeController{

	private SessionImpl sessionImpl;
	
	public ResumeControllerImpl(Session session) {
		super(session);
		this.sessionImpl= (SessionImpl) this.session;
	}

	@Override
	public void reset() {
        this.session.reset();
    }

}
