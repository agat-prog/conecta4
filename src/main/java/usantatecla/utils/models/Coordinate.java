package usantatecla.utils.models;

import java.io.Serializable;

public interface Coordinate extends Serializable {
  
  static Coordinate NULL = NullCoordinate.getInstance();
  boolean isNull();
  Coordinate[] getInDirectionCoordinates(Direction direction, int amount);
  Coordinate getInDirectionCoordinate(Direction direction);
  int getRow();
  int getColumn();
}
