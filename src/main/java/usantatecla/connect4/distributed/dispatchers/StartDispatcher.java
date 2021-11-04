package usantatecla.connect4.distributed.dispatchers;

import usantatecla.connect4.controllers.StartController;

public class StartDispatcher extends Dispatcher {

	public StartDispatcher(StartController startController) {
		super(startController);
	}

	@Override
	public void dispatch() {
		((StartController) this.acceptorController).start();
	}
}
