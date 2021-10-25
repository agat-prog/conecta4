package usantatecla.connect4.views.console;

import usantatecla.connect4.controllers.StartController;
import usantatecla.connect4.views.Message;

public class StartView{

    public void interact(StartController startController) {
    	startController.start();
    	new MessageView().writeln(Message.TITLE);
        new BoardView().write(startController);
    }

}
