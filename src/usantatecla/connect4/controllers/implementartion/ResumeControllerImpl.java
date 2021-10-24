package usantatecla.connect4.controllers.implementartion;

import usantatecla.connect4.controllers.ResumeController;
import usantatecla.connect4.models.Session;
import usantatecla.connect4.models.SessionImpl;

public class ResumeControllerImpl extends ResumeController{

	private SessionImpl sessionImpl;
	
	public ResumeControllerImpl(Session session) {
		super(session);
		this.sessionImpl= (SessionImpl) this.session;
	}

	public void resume(boolean resume) {
		if(resume) {
			this.sessionImpl.reset();
		}else {
			this.sessionImpl.next();
		}
	}
}
