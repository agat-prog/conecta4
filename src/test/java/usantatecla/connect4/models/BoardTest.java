package usantatecla.connect4.models;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import usantatecla.connect4.types.Color;
import usantatecla.utils.models.ConcreteCoordinate;
import usantatecla.utils.models.Coordinate;

public class BoardTest {
	
	private final int columnSelected = 1;
	private BoardBuilder boardBuilder;
	
	/* BOARD CONFIGURATIONS
	 UP DIAGONAL     DOWN DIAGONAL     COLUMN        ROW
		"RYYRRYR",      "RYYRRYR",     "R      ",    "RYYRRY ",          
		"YYRRYRY",      "YYRRYRY",     "R      ",    "YYRRYRY",
		"YRRYRYR",      "YRRYRYR",     "R      ",    "YRRYRYR",
		"RYRYRYR",      "RYRYRYR",     "R      ",    "RYRYRYR",
		"YRYRYRY",      "YRYRYRY",     "YYRY   ",    "YRRRRYY",
		"YRYRYRY"       "YRYRYRY"      "YRYRYRY"     "YRYYYRY"
	 */
	
	
	@BeforeEach
	public void init() {
		this.boardBuilder = new BoardBuilder();
	}
	
	@Test
	public void testGivenNewBoardWhenPutNewTokenThenIsOccupiedIsTrue() {
		Board board = this.boardBuilder.build();
		Coordinate coordinate = board.getEmptyCoordinate(columnSelected);
		board.putToken(columnSelected, Color.YELLOW);
		assertThat(board.isOccupied(coordinate, Color.YELLOW), is(true));
	}	
	
	@Test
	public void testGivenNewBoardWhenPutNewTokenThenIsOccupiedIsFalse() {
		Board board = this.boardBuilder.build();
		Coordinate coordinate = board.getEmptyCoordinate(columnSelected);
		assertThat(board.isOccupied(coordinate, Color.YELLOW), is(false));
	}	
	
	@Test
	public void testGivenNewBoardWhenGetEmptyCoordinateThenIsTrue() {
		Board board = this.boardBuilder.rows(
				"       ",
				"       ",
				"       ",
				"       ",
				"       ",
				"RYRRYYR"
				).build();
		assertThat(board.getEmptyCoordinate(columnSelected), is(new ConcreteCoordinate(1,0)));
	}
	
	@Test
	public void testGivenFullBoardWhenGetEmptyCoordinateThenIsNull() {
		Board board = this.boardBuilder.rows(
				"RYYRRYR",
				"YYRRYRY",
				"YRRYRYR",
				"RYRYRYR",
				"YRYRYRY",
				"YRYRYRY"
				).build();
		assertThat(board.getEmptyCoordinate(columnSelected), is(Coordinate.NULL));
	}
	
	@Test
	public void testGivenHalfFullBoardWhenIsConnect4ThenIsTrue() {
		Board board = this.boardBuilder.rows(
				"R      ",
				"R      ",
				"R      ",
				"R      ",
				"YYRY   ",
				"YRYRYRY"
				).build();
		assertThat(board.isConnect4(),is(true));
	}
	
	@Test
	public void testGivenNewBoardWhenIsConnect4ThenIsFalse() {
		Board board = this.boardBuilder.rows(
				"       ",
				"       ",
				"       ",
				"       ",
				"       ",
				"       "
				).build();
		assertThat(board.isConnect4(),is(false));
	}
	
	@Test
	public void testGivenBoardWhenIsConnect4UpDiagonalThenIsTrue() {
		Board board = this.boardBuilder.rows(
				"RYYRRYR",
				"YYRRYRY",
				"YRRYRYR",
				"RYRYRYR",
				"YRYRYRY",
				"YRYRYRY"
				).build();
		assertThat(board.isConnect4(),is(true));
	}
	
	@Test
	public void testGivenBoardWhenIsConnect4DownDiagonalThenIsTrue() {
		Board board = this.boardBuilder.rows(
				"RYYRRY ",
				"YYRRYRY",
				"YRRYRYR",
				"RYRYRYR",
				"YRYRYRY",
				"YRRYYRY"
				).build();
		assertThat(board.isConnect4(),is(true));
	}
	
	@Test
	public void testGivenBoardWhenIsConnect4ColumnThenIsTrue() {
		Board board = this.boardBuilder.rows(
				"RYYRRY ",
				"YYRRYRY",
				"YRRYRYR",
				"RYRYRYR",
				"YRRRRYY",
				"YRYYYRY"
				).build();
		assertThat(board.isConnect4(),is(true));
	}
	
	@Test
	public void testGivenBoardWhenIsConnect4ThenIsFalse() {
		Board board = this.boardBuilder.rows(
				"YYYRYRY",
				"RRRYYRR",
				"RYRYRYR",
				"YRYRYRY",
				"YRYYYRY",
				"RYRYRYR"
				).build();
		assertThat(board.isConnect4(),is(false));
	}
	
	@Test
	public void givenBoardWhenPutTokenThenChangeBoard() {
		Board board = new Board();
		board.putToken(1, Color.RED);
		
		assertThat(board.getColor(new ConcreteCoordinate(0, 0)), is(Color.RED));
	}
	
	@Test
	public void givenBoardWhenPutTokenOnMaxColumnThenException() {
		Assertions.assertThrows(AssertionError.class, () -> {
			new Board().putToken(Integer.MAX_VALUE, Color.RED);
		});
	}
	
	@Test
	public void givenBoardWhenPutTokenOnMinColumnThenException() {
		Assertions.assertThrows(AssertionError.class, () -> {
			new Board().putToken(Integer.MIN_VALUE, Color.RED);
		});
	}
	
	@Test
	public void givenBoardWhenGetEmptyCoordinateOnMinColumnThenException() {
		Assertions.assertThrows(AssertionError.class, () -> {
			new Board().getEmptyCoordinate(Integer.MIN_VALUE);
		});
	}
	
	@Test
	public void givenBoardWhenGetEmptyCoordinateOnMaxColumnThenException() {
		Assertions.assertThrows(AssertionError.class, () -> {
			new Board().getEmptyCoordinate(Integer.MAX_VALUE);
		});
	}
	
	static boolean isSameValues(Board board1, Board board2) {
		boolean isSame = true;
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
            	isSame = board1.getColor(new ConcreteCoordinate(i, j)).equals(board2.getColor(new ConcreteCoordinate(i, j)));
            	if (!isSame) {
            		return isSame;
            	}
            }
        }
        return isSame;
	}
}
