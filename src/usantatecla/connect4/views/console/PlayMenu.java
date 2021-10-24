package usantatecla.connect4.views.console;

import usantatecla.connect4.controllers.PlayController;
import usantatecla.utils.views.Menu;

public class PlayMenu extends Menu{
	PlayMenu(PlayController playController){
		this.addCommand(new ActionCommand(playController));
		this.addCommand(new UndoCommand(playController));
		this.addCommand(new RedoCommand(playController));
	}
}
