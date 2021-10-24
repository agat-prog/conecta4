package usantatecla.connect4;

import usantatecla.connect4.controllers.Logic;
import usantatecla.connect4.controllers.implementartion.LogicImpl;

class ConsoleConnect4 extends Connect4 {

	@Override
	protected Logic createLogic(){
		return new LogicImpl();
	}

	public static void main(String[] args) {
		new ConsoleConnect4().play();
	}

}
