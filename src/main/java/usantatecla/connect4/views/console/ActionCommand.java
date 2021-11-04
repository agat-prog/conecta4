package usantatecla.connect4.views.console;

import usantatecla.connect4.controllers.PlayController;
import usantatecla.connect4.views.Message;

public class ActionCommand extends Command{
	
	protected ActionCommand(PlayController playController) {
		super(Message.ACTION_COMMAND.toString(), playController);
	}

	@Override
	public void execute() {
		new PlayerView(this.playController).interact();
	    this.playController.next();
		super.execute();
	}

	@Override
	public boolean isActive() {
		return true;
	}

}
