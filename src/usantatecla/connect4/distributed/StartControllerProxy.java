package usantatecla.connect4.distributed;

import usantatecla.connect4.controllers.StartController;
import usantatecla.connect4.distributed.dispatchers.FrameType;
import usantatecla.connect4.models.Session;
import usantatecla.utils.TCPIP;

public class StartControllerProxy extends StartController {
	
	private TCPIP tcpip;

	public StartControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public void start() {
		this.tcpip.send(FrameType.START.name());
	}
}
