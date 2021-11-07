package usantatecla.connect4.models;

public class RegistryBuilder {

	private Registry registry;
	
	public RegistryBuilder() {
		Game game = new GameBuilder().build();
		this.registry = new Registry(game);
	}
	
	public Registry build() {
		return this.registry;
	}
}
