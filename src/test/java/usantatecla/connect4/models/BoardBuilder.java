package usantatecla.connect4.models;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import usantatecla.connect4.types.Color;
import usantatecla.utils.models.ConcreteCoordinate;

public class BoardBuilder {

	private List<String> rows;
	
	public BoardBuilder() {
		this.rows = new ArrayList<>();
	}
	
	//String... es un operador que permite argumentos variables (varags) 
    public BoardBuilder rows(String... rows) {
    	assert rows.length == 6;
    	for(String row: rows) {
    		assert Pattern.matches("[RY ]{7}", row);
    		this.rows.add(row);
    	}
    	return this;
    }
    
    public Board build() {
    	Board board = new Board();
    	int i = 0;
    	if(!this.rows.isEmpty()) {
    		for (int iRows = this.rows.size(); iRows > 0; iRows--) {
                String string = this.rows.get(iRows-1);
                for (int j = 0; j < string.length(); j++) {
                    board.putToken(new ConcreteCoordinate(i, j), this.getColor(string.charAt(j)));
                    
                }
                i++;
    		}
    	}
    	return board;
    }
    
    private Color getColor(char character) {
        Color result = Color.NULL;
        for (int i = 0; i < Color.values().length - 1; i++) {
            Color color = Color.values()[i];
            if (color.name().charAt(0) == character) {
                result = color;
            }
        }
        return result;
    }
}
