package usantatecla.utils.models;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ConcreteCoordinateTest {

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
}
