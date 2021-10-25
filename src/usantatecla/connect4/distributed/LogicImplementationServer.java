package usantatecla.connect4.distributed;

import usantatecla.connect4.controllers.implementation.LogicImpl;
import usantatecla.connect4.distributed.dispatchers.ColorActiveDispatcher;
import usantatecla.connect4.distributed.dispatchers.DispatcherPrototype;
import usantatecla.connect4.distributed.dispatchers.FrameType;
import usantatecla.connect4.distributed.dispatchers.StartDispatcher;
import usantatecla.connect4.distributed.dispatchers.StateDispatcher;

public class LogicImplementationServer extends LogicImpl {

	public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
		dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.startControllerImpl));
		dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.playControllerImpl));
		dispatcherPrototype.add(FrameType.COLOR, new ColorActiveDispatcher(this.playControllerImpl));
	}
}
