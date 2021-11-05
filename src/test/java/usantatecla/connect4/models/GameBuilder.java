package usantatecla.connect4.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import usantatecla.connect4.types.Color;

public class GameBuilder {

	
	private Board board;
	private Color color;
	private String[] rows;
	private Game game;
	
	public GameBuilder() {
		this.rows = new String[] {
				"       ",
				"       ",
				"       ",
				"       ",
				"       ",
				"       "};
	}
	
	public GameBuilder rows(String... rows) {
		this.rows = rows;
		return this;
	}
	
	public GameBuilder turn(Color color) {
        this.color = color;
        return this;
    }
	
	public Game build() {
		this.game = new Game();
		this.boardBuild();
		if (this.color != null && this.game.getActiveColor() != this.color) {
            this.game.next();
        }
        return this.game;
	}
	
	public void boardBuild() {
		char colorTurn = 'R';
		Map<Character,Integer> tokens = new HashMap<>();
		tokens.put('R', 0);
		tokens.put('Y', 0);
		for(int i=rows.length-1; i>= 0; i--) {
			ArrayList<Integer> otherColorIndex = new ArrayList<>() ;
			for(int j= 1; j<= this.board.COLUMNS; j++) {
				char color = this.rows[i].charAt(j-1);
				if(color == colorTurn) {
					this.game.putToken(j);
					tokens.put(color, tokens.get(color)+1);
				}else if(color != ' '){
					this.game.next();
					colorTurn = color;
					this.game.putToken(j);
					tokens.put(color, tokens.get(color)+1);
				}
			}
		}
		if(tokens.get('R') == tokens.get('Y') && colorTurn == 'Y'){
			this.game.next();
		}else if(tokens.get('R') >= tokens.get('Y') && colorTurn == 'R') {
			this.game.next();
		}
		//if(tokens.get('R') < tokens.get('Y') || tokens.get('R') - tokens.get('Y') > 1)
		//	throw new Exception("Incorrect board");
	}
	
	public void putTokens(Board board, Color color) {
	 this.game.putToken(0);
	}
}
