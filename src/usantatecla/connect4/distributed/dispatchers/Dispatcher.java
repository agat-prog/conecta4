package usantatecla.connect4.distributed.dispatchers;

import usantatecla.connect4.controllers.AcceptorController;

public abstract class Dispatcher {
	
	protected AcceptorController acceptorController;
	
	protected TCPIP tcpip;
	
	public Dispatcher (AcceptorController acceptorController) {
		this.acceptorController = acceptorController;
	}

	public abstract void dispatch();
	
	public void associate(TCPIP tcpip) {
		this.tcpip = tcpip;
	}

}
