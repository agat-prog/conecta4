package usantatecla.connect4.models;

import usantatecla.connect4.types.Color;
import usantatecla.connect4.types.Error;

public class Turn {

    private Board board;
    public static final int NUMBER_PLAYERS = 2;
    private Player[] players;
    private int activePlayer;

    Turn(Board board) {
        assert board != null;
        this.board = board;
        this.players = new Player[Turn.NUMBER_PLAYERS];
        this.reset();
    }

    void reset() {
        for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
            this.players[i] = new Player(Color.get(i), this.board);
        }
        this.activePlayer = 0;
    }

    void next() {
        if (!this.board.isConnect4()) {
            this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;
        }
    }

    Player getActivePlayer() {
        return this.players[this.activePlayer];
    }

    Color getActiveColor() {
        return this.getActivePlayer().getColor();
    }

    void putToken(int column) {
        this.getActivePlayer().putToken(column);
    }

    Error getPutTokenError(int column) {
        return this.getActivePlayer().getPutTokenError(column);
    }

	public void setActivePlayer(int activePlayer) {
		this.activePlayer = activePlayer;
	}

	public void setPlayerPutTokens(Color color, int playerPutTokens) {
		 this.players[color.ordinal()].set(playerPutTokens);
	}
}
