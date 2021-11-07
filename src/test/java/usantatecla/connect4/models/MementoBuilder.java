package usantatecla.connect4.models;

public class MementoBuilder {

	private Memento memento;
	
	public MementoBuilder() {
		Board board = new BoardBuilder().rows(
				"       ",
				"       ",
				"       ",
				"       ",
				"       ",
				"RYRRYYR"
				).build();
		Turn turn = new Turn(board);
		turn.next();
		this.memento = new Memento(board, turn);
	}
	
	public Memento build() {
		return this.memento;
	}
}
