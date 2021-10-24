package usantatecla.connect4;

import usantatecla.connect4.controllers.Logic;
import usantatecla.connect4.controllers.implementation.LogicImpl;

class Connect4Standalone extends Connect4 {

	@Override
	protected Logic createLogic(){
		return new LogicImpl();
	}

	public static void main(String[] args) {
		new Connect4Standalone().play();
	}

}
