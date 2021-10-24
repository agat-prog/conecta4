package usantatecla.connect4.models;

import java.util.Arrays;

import usantatecla.connect4.types.Color;
import usantatecla.utils.models.ConcreteCoordinate;
import usantatecla.utils.models.Coordinate;
import usantatecla.utils.models.Direction;

public class Board {

    public static final int ROWS = 6;
    public static final int COLUMNS = 7;

    private Color[][] colors;

    Board() {
        this.colors = new Color[Board.ROWS][Board.COLUMNS];
        this.reset();
    }

    void reset() {
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
                this.colors[i][j] = Color.NULL;
            }
        }
    }
    
    Color[][] copy(){
    	return Arrays.stream(this.colors).map(Color[]::clone).toArray(Color[][]::new);
    }

    void putToken(int column, Color color) {
        ConcreteCoordinate coordinate =  this.getEmptyCoordinate(column - 1);
        this.colors[coordinate.getRow()][coordinate.getColumn()] = color;
    }
    
    void putToken(Coordinate coordinate, Color color) {
        assert !coordinate.isNull();

        this.colors[coordinate.getRow()][coordinate.getColumn()] = color;
    }

    ConcreteCoordinate getEmptyCoordinate(int column) {
        ConcreteCoordinate current = new ConcreteCoordinate(Board.ROWS-1, column);
        if (!this.isEmpty(current)) {
            return null;
        }
        ConcreteCoordinate previous;
        do {
            previous = current;
            current = current.getInDirectionCoordinate(Direction.SOUTH);
        } while (isValid(current) && this.isEmpty(current));
        return previous;
    }

    private boolean isValid(ConcreteCoordinate coordinate) {
        return 0 <= coordinate.getRow() && coordinate.getRow() < Board.ROWS
                && 0 <= coordinate.getColumn() && coordinate.getColumn() < Board.COLUMNS;
    }

    boolean thereIsEmpty(int column) {
        return !this.getEmptyCoordinate(column).isNull();
    }

    private boolean isEmpty(ConcreteCoordinate coordinate) {
        return this.getColor(coordinate) == Color.NULL;
    }

    Color getColor(Coordinate coordinate) {
    	return this.colors[coordinate.getRow()][coordinate.getColumn()];
    }

    boolean isOccupied(ConcreteCoordinate coordinate, Color color) {
        return this.getColor(coordinate) == color;
    }

    boolean isConnect4() {
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
                if (this.isConnect4(new ConcreteCoordinate(i, j))) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean isConnect4(ConcreteCoordinate coordinate) {
        for (Direction direction : new Direction[] { Direction.EAST, Direction.SOUTH_EAST, Direction.SOUTH, Direction.SOUTH_WEST }) {
            if (this.isConnect4(coordinate, direction)) {
                return true;
            }
        }
        return false;
    }

    boolean isConnect4(ConcreteCoordinate coordinate, Direction direction) {
        assert !direction.isNull();
        assert this.isValid(coordinate);

        ConcreteCoordinate[] coordinates = coordinate.getInDirectionCoordinates(direction, 4);
         for (int i = 0; i < coordinates.length - 1; i++) {
            if (!this.isValid(coordinates[i+1]) || this.getColor(coordinates[i]) != this.getColor(coordinates[i + 1])) {
                return false;
            }
        }
        return this.getColor(coordinates[0]) != Color.NULL;
    }

}
