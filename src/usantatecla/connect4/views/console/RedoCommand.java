package usantatecla.connect4.views.console;

import usantatecla.connect4.controllers.PlayController;
import usantatecla.connect4.views.Message;

public class RedoCommand extends Command{

	protected RedoCommand(PlayController playController) {
		super(Message.REDO_COMMAND.toString(), playController);
	}

	@Override
	public void execute() {
		this.playController.redo();
		super.execute();
	}

	@Override
	public boolean isActive() {
		return this.playController.redoable();
	}

}
