package usantatecla.connect4.controllers.implementartion;

import usantatecla.connect4.controllers.Logic;
import usantatecla.connect4.controllers.NullController;
import usantatecla.connect4.models.SessionImpl;
import usantatecla.connect4.models.StateValue;

public class LogicImpl extends Logic{

	protected StartControllerImpl startControllerImpl;

	protected PlayControllerImpl playControllerImpl;

	protected ResumeControllerImpl resumeControllerImpl;

	public LogicImpl() {
		this.session = new SessionImpl();
		this.startControllerImpl= new StartControllerImpl(this.session);
		this.playControllerImpl= new PlayControllerImpl(this.session);
		this.resumeControllerImpl= new ResumeControllerImpl(this.session);
		this.acceptorControllers.put(StateValue.INITIAL, this.startControllerImpl);
        this.acceptorControllers.put(StateValue.IN_GAME, this.playControllerImpl);
        this.acceptorControllers.put(StateValue.RESUME, this.resumeControllerImpl);
        this.acceptorControllers.put(StateValue.EXIT, NullController.getInstance());
	}
}