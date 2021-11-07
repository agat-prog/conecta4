package usantatecla.connect4.models;

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
    	Color[][] copia = new Color[Board.ROWS][Board.COLUMNS];
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
            	copia[i][j] = this.colors[i][j];
            }
        }
    	return copia;
    }

    void putToken(int column, Color color) {
    	assert column > 0 && column <= COLUMNS;
    	
        Coordinate coordinate =  this.getEmptyCoordinate(column);
        this.colors[coordinate.getRow()][coordinate.getColumn()] = color;
    }
    
    void putToken(Coordinate coordinate, Color color) {
        assert !coordinate.isNull();

        this.colors[coordinate.getRow()][coordinate.getColumn()] = color;
    }

    Coordinate getEmptyCoordinate(int column) {
    	assert column > 0 && column <= COLUMNS;
    	
        ConcreteCoordinate current = new ConcreteCoordinate(Board.ROWS - 1, column - 1);
        if (!this.isEmpty(current)) {
        	return Coordinate.NULL;
        }
        
        ConcreteCoordinate previous;
        do {
            previous = current;
            current = current.getInDirectionCoordinate(Direction.SOUTH);
        } 
        while (isValid(current) && this.isEmpty(current));
        
        return previous;
    }

    private boolean isValid(Coordinate coordinate) {
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

    boolean isOccupied(Coordinate coordinate, Color color) {
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

    boolean isConnect4(Coordinate coordinate) {
        for (Direction direction : new Direction[] { Direction.EAST, Direction.SOUTH_EAST, Direction.SOUTH, Direction.SOUTH_WEST }) {
            if (this.isConnect4(coordinate, direction)) {
                return true;
            }
        }
        return false;
    }

    boolean isConnect4(Coordinate coordinate, Direction direction) {
        assert !direction.isNull();
        assert this.isValid(coordinate);

        Coordinate[] coordinates = coordinate.getInDirectionCoordinates(direction, 4);
         for (int i = 0; i < coordinates.length - 1; i++) {
            if (!this.isValid(coordinates[i+1]) || this.getColor(coordinates[i]) != this.getColor(coordinates[i + 1])) {
                return false;
            }
        }
        return this.getColor(coordinates[0]) != Color.NULL;
    }

}
