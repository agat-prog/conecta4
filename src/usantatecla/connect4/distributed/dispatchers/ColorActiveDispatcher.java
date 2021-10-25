package usantatecla.connect4.distributed.dispatchers;

import usantatecla.connect4.controllers.PlayController;
import usantatecla.connect4.types.Color;
import usantatecla.utils.models.Coordinate;

public class ColorActiveDispatcher extends Dispatcher {

	public ColorActiveDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		Coordinate coordinate = (Coordinate) this.tcpip.receiveObject();
		Color color = ((PlayController) this.acceptorController).getColor(coordinate);
		this.tcpip.send(color.ordinal());
	}
}