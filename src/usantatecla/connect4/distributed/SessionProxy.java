package usantatecla.connect4.distributed;

import usantatecla.connect4.distributed.dispatchers.FrameType;
import usantatecla.connect4.models.Session;
import usantatecla.connect4.models.StateValue;
import usantatecla.connect4.types.Color;
import usantatecla.utils.TCPIP;
import usantatecla.utils.models.Coordinate;

public class SessionProxy implements Session {
	
	private TCPIP tcpip;

	public SessionProxy(TCPIP tcpip) {
		this.tcpip = tcpip;
	}
	
	public StateValue getValueState() {
		this.tcpip.send(FrameType.STATE.name());
		return StateValue.values()[this.tcpip.receiveInt()];
	}

	@Override
	public Color getColor(Coordinate coordinate) {
		this.tcpip.send(FrameType.COLOR.name());
		this.tcpip.send(coordinate);
		return Color.values()[this.tcpip.receiveInt()];
	}

	@Override
	public Color getActiveColor() {
		this.tcpip.send(FrameType.ACTIVE_COLOR.name());
		return Color.values()[this.tcpip.receiveInt()];
	}
}
