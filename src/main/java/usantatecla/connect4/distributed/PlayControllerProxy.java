package usantatecla.connect4.distributed;

import usantatecla.connect4.controllers.PlayController;
import usantatecla.connect4.distributed.dispatchers.FrameType;
import usantatecla.connect4.distributed.dispatchers.TCPIP;
import usantatecla.connect4.models.Session;
import usantatecla.connect4.types.Color;
import usantatecla.connect4.types.Error;

public class PlayControllerProxy extends PlayController {

	private TCPIP tcpip;

	PlayControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public void undo() {
		this.tcpip.send(FrameType.UNDO.name());
	}

	@Override
	public void redo() {
		this.tcpip.send(FrameType.REDO.name());
	}

	@Override
	public boolean undoable() {
		this.tcpip.send(FrameType.UNDOABLE.name());
		return this.tcpip.receiveBoolean();
	}

	@Override
	public boolean redoable() {
		this.tcpip.send(FrameType.REDOABLE.name());
		return this.tcpip.receiveBoolean();
	}

	@Override
	public boolean isConnect4() {
		return false;
	}

	@Override
	public void next() {
	}

	@Override
	public Color getActiveColor() {
		return null;
	}

	@Override
	public void putToken(int column) {
	}

	@Override
	public Error getPutTokenError(int column) {
		return null;
	}

	@Override
	public void nextState() {
	}

}
