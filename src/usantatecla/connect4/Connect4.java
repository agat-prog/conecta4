package usantatecla.connect4;

import usantatecla.connect4.controllers.AcceptorController;
import usantatecla.connect4.controllers.Logic;
import usantatecla.connect4.views.View;

abstract class Connect4 {

    private View view;
    private Logic logic;

    protected Connect4() {
        this.logic = new Logic();
        this.view = this.createView();
    }

    protected abstract View createView();

    protected void play() {
        AcceptorController controller;
        do {
            controller = logic.getController();
            controller.accept(this.view);
        } 
        while (!controller.isNull());
    }
}
