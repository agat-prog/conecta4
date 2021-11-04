package usantatecla.connect4.distributed;

import usantatecla.connect4.distributed.dispatchers.DispatcherPrototype;

public class Conecta4Server {

	private DispatcherPrototype dispatcherPrototype;

	private LogicImplementationServer logic;

	private Conecta4Server() {
		this.dispatcherPrototype = new DispatcherPrototype();
		this.logic = new LogicImplementationServer();
		this.logic.createDispatchers(this.dispatcherPrototype);
	}

	private void serve() {
		this.dispatcherPrototype.serve();
	}

	public static void main(String[] args) {
		new Conecta4Server().serve();
	}

}
