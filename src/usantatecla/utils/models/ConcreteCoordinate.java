package usantatecla.utils.models;

public class ConcreteCoordinate implements Coordinate {
	
	public static final String ROW = "Row: ";
	public static final String COLUMN = "Column: ";
	protected int row;
	protected int column;

	public ConcreteCoordinate() {
	}

	public ConcreteCoordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

	@Override
	public boolean isNull() {
		return false;
	}

	public ConcreteCoordinate[] getInDirectionCoordinates(Direction direction, int amount){
		ConcreteCoordinate[] coordinates = new ConcreteCoordinate[amount];
		coordinates[0] = this;
		for(int i=1; i<amount; i++){
			coordinates[i] = coordinates[i-1].getInDirectionCoordinate(direction);
		}
		return coordinates;
	}

	public ConcreteCoordinate getInDirectionCoordinate(Direction direction) {
		return new ConcreteCoordinate(this.row + direction.getRow(), this.column + direction.getColumn());
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConcreteCoordinate other = (ConcreteCoordinate) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coordinate (" + row + ", " + column + ")";
	}

}
