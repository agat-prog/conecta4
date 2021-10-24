package usantatecla.utils.models;

class NullCoordinate implements Coordinate {

    private static NullCoordinate instance;

    static Coordinate getInstance() {
        if (NullCoordinate.instance == null) {
            NullCoordinate.instance = new NullCoordinate();
        }
        return NullCoordinate.instance;
    }

    private NullCoordinate() {
    }

    @Override
    public boolean isNull() {
        return true;
    }


    @Override
    public String toString() {
        return "Coordinate (NULL)";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public Coordinate[] getInDirectionCoordinates(Direction direction, int amount) {
        return null;
    }

    @Override
    public Coordinate getInDirectionCoordinate(Direction direction) {
        return null;
    }

	@Override
	public int getRow() {
		return 0;
	}

	@Override
	public int getColumn() {
		return 0;
	}
}
