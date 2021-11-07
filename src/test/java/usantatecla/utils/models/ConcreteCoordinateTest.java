package usantatecla.utils.models;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import usantatecla.utils.models.ConcreteCoordinate;
import usantatecla.utils.models.Direction;

public class ConcreteCoordinateTest {
	
	private static final int MAX_COLS_ROWS = 7;

	@Test
	public void testGivenCoordinateWhenDirectionEastThenCoordinateEast() {
		ConcreteCoordinate coordinate = new ConcreteCoordinate();
		ConcreteCoordinate coordinateEast = coordinate.getInDirectionCoordinate(Direction.EAST);
		Assert.assertTrue(coordinateEast.getColumn() == coordinate.getColumn() + 1);
		Assert.assertTrue(coordinateEast.getRow() == coordinate.getRow());
	}
	
	@Test
	public void testGivenCoordinateWhenDirectionWestThenCoordinateWeast() {
		ConcreteCoordinate coordinate = new ConcreteCoordinate();
		ConcreteCoordinate coordinateEast = coordinate.getInDirectionCoordinate(Direction.WEST);
		Assert.assertTrue(coordinateEast.getColumn() == coordinate.getColumn() - 1);
		Assert.assertTrue(coordinateEast.getRow() == coordinate.getRow());
	}
	
	@Test
	public void testGivenCoordinateWhenDirectionNorthThenCoordinateNorth() {
		ConcreteCoordinate coordinate = new ConcreteCoordinate();
		ConcreteCoordinate coordinateEast = coordinate.getInDirectionCoordinate(Direction.NORTH);
		Assert.assertTrue(coordinateEast.getColumn() == coordinate.getColumn());
		Assert.assertTrue(coordinateEast.getRow() == coordinate.getRow() + 1);
	}
	
	@Test
	public void testGivenCoordinateWhenDirectionSouthThenCoordinateSouth() {
		ConcreteCoordinate coordinate = new ConcreteCoordinate();
		ConcreteCoordinate coordinateEast = coordinate.getInDirectionCoordinate(Direction.SOUTH);
		Assert.assertTrue(coordinateEast.getColumn() == coordinate.getColumn());
		Assert.assertTrue(coordinateEast.getRow() == coordinate.getRow() - 1);
	}
	
	@Test
	public void testGivenCoordinateWhenDirectionNullThenCoordinateEquals() {
		ConcreteCoordinate coordinate = new ConcreteCoordinate();
		ConcreteCoordinate coordinateEast = coordinate.getInDirectionCoordinate(Direction.NULL);
		Assert.assertTrue(coordinateEast.getColumn() == coordinate.getColumn());
		Assert.assertTrue(coordinateEast.getRow() == coordinate.getRow());
	}
	
	@Test
	public void testGivenCoordinateWhenDirectionNorthEastThenCoordinateNorthEast() {
		ConcreteCoordinate coordinate = new ConcreteCoordinate();
		ConcreteCoordinate coordinateEast = coordinate.getInDirectionCoordinate(Direction.NORTH_EAST);
		Assert.assertTrue(coordinateEast.getColumn() == coordinate.getColumn() + 1);
		Assert.assertTrue(coordinateEast.getRow() == coordinate.getRow() + 1);
	}
	
	@Test
	public void testGivenCoordinateWhenDirectionNorthWestThenCoordinateNorthWest() {
		ConcreteCoordinate coordinate = new ConcreteCoordinate();
		ConcreteCoordinate coordinateEast = coordinate.getInDirectionCoordinate(Direction.NORTH_WEST);
		Assert.assertTrue(coordinateEast.getColumn() == coordinate.getColumn() - 1);
		Assert.assertTrue(coordinateEast.getRow() == coordinate.getRow() + 1);
	}
	
	@Test
	public void testGivenCoordinateWhenDirectionSouthEastThenCoordinateSouthEast() {
		ConcreteCoordinate coordinate = new ConcreteCoordinate();
		ConcreteCoordinate coordinateEast = coordinate.getInDirectionCoordinate(Direction.SOUTH_EAST);
		Assert.assertTrue(coordinateEast.getColumn() == coordinate.getColumn() + 1);
		Assert.assertTrue(coordinateEast.getRow() == coordinate.getRow() - 1);
	}
	
	@Test
	public void testGivenCoordinateWhenDirectionSouthWestThenCoordinateSouthWest() {
		ConcreteCoordinate coordinate = new ConcreteCoordinate();
		ConcreteCoordinate coordinateEast = coordinate.getInDirectionCoordinate(Direction.SOUTH_WEST);
		Assert.assertTrue(coordinateEast.getColumn() == coordinate.getColumn() - 1);
		Assert.assertTrue(coordinateEast.getRow() == coordinate.getRow() - 1);
	}
	
	@Test
	public void testGivenCoordinateWhenGetInDirectionAndInvalidAmountThenAssertionException() {
		Assertions.assertThrows(AssertionError.class, () -> {
			new ConcreteCoordinate().getInDirectionCoordinates(Direction.NORTH, Integer.MIN_VALUE);
		});
	}
	
	@Test
	public void testGivenCoordinateWhenGetInDirectionAndMaxAmountThenAssertionException() {
		Assertions.assertThrows(AssertionError.class, () -> {
			new ConcreteCoordinate().getInDirectionCoordinates(Direction.NORTH, Integer.MAX_VALUE);
		});
	}
	
	@Test
	public void testGivenCoordinateWhenGeInDirectionAmountThenArrayOfCoordinate() {
		ConcreteCoordinate coordinate = new ConcreteCoordinate();
		ConcreteCoordinate[] coordinateArray = coordinate.getInDirectionCoordinates(Direction.EAST, MAX_COLS_ROWS);
		Assert.assertTrue(coordinateArray.length == MAX_COLS_ROWS);
	}
	
	@Test
	public void testGivenCoordinateWhenIsNullQuestionThenFalse() {
		Assert.assertFalse(new ConcreteCoordinate().isNull());
	}
}
