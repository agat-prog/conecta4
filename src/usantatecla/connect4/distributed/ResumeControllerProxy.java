package usantatecla.connect4.distributed;

import usantatecla.connect4.controllers.ResumeController;
import usantatecla.connect4.distributed.dispatchers.FrameType;
import usantatecla.connect4.models.Session;
import usantatecla.utils.TCPIP;

public class ResumeControllerProxy extends ResumeController {
	
	private TCPIP tcpip;

	public ResumeControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public void resume(boolean newGame) {
		this.tcpip.send(FrameType.NEW_GAME.name());
		this.tcpip.send(newGame);	
	}
}
