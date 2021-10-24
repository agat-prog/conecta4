package usantatecla.connect4.views.console;

import usantatecla.connect4.controllers.PlayController;
import usantatecla.connect4.views.Message;

public class PlayView {

    public void interact(PlayController playController) {
        do {
            new PlayMenu(playController).execute();
        } 
        while (!playController.isConnect4());
        new MessageView().writeln(Message.PLAYER_WIN, playController.getActiveColor().toString());
        playController.nextState();
    }
}
