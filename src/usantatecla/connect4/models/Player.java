package usantatecla.connect4.models;

import usantatecla.connect4.types.Color;
import usantatecla.connect4.types.Error;

class Player {

    private Color color;
    private Board board;
    private int putTokens;

    Player(Color color, Board board) {
        assert !color.isNull();
        assert board != null;

        this.color = color;
        this.board = board;
        this.putTokens = 0;
    }

    void putToken(int column) {
        this.board.putToken(column, this.color);
        this.putTokens++;
    }

    Error getPutTokenError(int column) {
        if (!this.board.thereIsEmpty(column)) {
            return Error.NOT_EMPTY;
        }
        return Error.NULL;
    }

    Color getColor() {
        return this.color;
    }

	public void set(int playerPutTokens) {
		this.putTokens = playerPutTokens;
	}
//    
//	boolean areAllTokensOnBoard() {
//        return this.putTokens == Coordinate.DIMENSION;
//    }
}
