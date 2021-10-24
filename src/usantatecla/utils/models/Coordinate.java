package usantatecla.utils.models;

public interface Coordinate {
  
  static Coordinate NULL = NullCoordinate.getInstance();
  boolean isNull();
  Coordinate[] getInDirectionCoordinates(Direction direction, int amount);
  Coordinate getInDirectionCoordinate(Direction direction);
  int getRow();
  int getColumn();
}
