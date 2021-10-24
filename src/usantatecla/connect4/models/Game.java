package usantatecla.connect4.models;

import usantatecla.connect4.types.Color;
import usantatecla.connect4.types.Error;
import usantatecla.utils.models.Coordinate;

public class Game {

    private Board board;
    private Turn turn;

    public Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public void reset() {
        this.board.reset();
        this.turn.reset();
    }

    public void next() {
        this.turn.next();
    }

    public Color getActiveColor() {
        return this.turn.getActiveColor();
    }

    public boolean isConnect4() {
        return this.board.isConnect4();
    }

    public Color getColor(Coordinate coordinate) {
        return this.board.getColor(coordinate);
    }

    public void putToken(int column) {
        this.turn.putToken(column);
    }

    public Error getPutTokenError(int column) {
        return this.turn.getPutTokenError(column);
    }

	public Memento createMemento() {
		return new Memento(this.board, this.turn);
	}

	public void setMemento(Memento memento) {
		this.board = memento.getBoard();
		this.turn = new Turn(this.board);
		this.turn.setActivePlayer(memento.getActivePlayer());
		for (Color color : Color.getAll()) {
			this.turn.setPlayerPutTokens(color, memento.getPlayerPutTokens(color));
		}
		
	}
}
