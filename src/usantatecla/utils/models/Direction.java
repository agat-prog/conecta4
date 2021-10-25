package usantatecla.utils.models;

public enum Direction {

	NORTH(1,0),
	NORTH_EAST(1,1),
	EAST(0,1),
	SOUTH_EAST(-1,1),
	SOUTH(-1,0),
	SOUTH_WEST(-1,-1),
	WEST(0,-1),
	NORTH_WEST(1,-1),
	NULL;

	private int row;
	private int column;

	private Direction(){
	}

	private Direction(int row, int column){
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public boolean isNull() {
		return this == Direction.NULL;
	}	

	

}
