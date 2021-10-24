package usantatecla.connect4.views.console;

import usantatecla.connect4.controllers.StartController;
import usantatecla.connect4.views.Message;

class StartView{

    void interact(StartController startController) {
        new MessageView().writeln(Message.TITLE);
        new BoardView().write(startController);
        startController.nextState();
    }

}
