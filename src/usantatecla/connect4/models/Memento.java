package usantatecla.connect4.models;

import usantatecla.connect4.types.Color;
import usantatecla.utils.models.ConcreteCoordinate;

public class Memento {

	private int activePlayer;
	private Color[][] colors;

    Memento(Board board, Turn turn) {
    	this.colors = board.copy();
        this.activePlayer = turn.getActiveColor().ordinal();
    }

    Board getBoard() {
        Board board = new Board();
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
            	 board.putToken(new ConcreteCoordinate(i, j), colors[i][j]);
            }
        }
        return board;
    }

    int getActivePlayer() {
        return this.activePlayer;
    }

    int getPlayerPutTokens(Color color) {
        int playerPutTokens = 0;
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
                if (this.colors[i][j] == color) {
                    playerPutTokens++;
                }
            }
        }
        return playerPutTokens;
    }
}
