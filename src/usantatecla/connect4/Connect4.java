package usantatecla.connect4;

import usantatecla.connect4.controllers.AcceptorController;
import usantatecla.connect4.controllers.Logic;
import usantatecla.connect4.views.View;

abstract class Connect4 {

    private View view;
    private Logic logic;

    protected Connect4() {
        this.logic = this.createLogic();
        this.view = new View();
    }

    protected abstract Logic createLogic();

    protected void play() {
        
		AcceptorController acceptorController;
	    do {
	    	acceptorController = logic.getController();
	        if (acceptorController != null){
				this.view.interact(acceptorController);
	        } 
	    }while (!acceptorController.isNull());
    }

}
