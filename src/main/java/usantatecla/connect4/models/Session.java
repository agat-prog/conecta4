package usantatecla.connect4.models;

import usantatecla.connect4.types.Color;
import usantatecla.utils.models.Coordinate;

public interface Session {
	
	public StateValue getValueState();
	public Color getColor(Coordinate coordinate);
	public Color getActiveColor();
}
