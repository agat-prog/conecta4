package usantatecla.connect4.distributed;

import usantatecla.connect4.controllers.Logic;
import usantatecla.connect4.controllers.NullController;
import usantatecla.connect4.distributed.dispatchers.TCPIP;
import usantatecla.connect4.models.StateValue;

public class LogicProxy extends Logic {
	
	private TCPIP tcpip;
	
	public LogicProxy() {
		this.tcpip = TCPIP.createClientSocket();
		this.session = new SessionProxy(this.tcpip);
		this.acceptorControllers.put(StateValue.INITIAL, new StartControllerProxy(this.session,this.tcpip));
		this.acceptorControllers.put(StateValue.IN_GAME, new PlayControllerProxy(this.session,this.tcpip));
		this.acceptorControllers.put(StateValue.RESUME, new ResumeControllerProxy(this.session,this.tcpip));
		this.acceptorControllers.put(StateValue.EXIT, NullController.getInstance());
	}

	public void close() {
		this.tcpip.close();
	}
	
}
