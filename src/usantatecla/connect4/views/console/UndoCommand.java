package usantatecla.connect4.views.console;

import usantatecla.connect4.controllers.PlayController;
import usantatecla.connect4.views.Message;

public class UndoCommand extends Command{

	protected UndoCommand(PlayController playController) {
		super(Message.UNDO_COMMAND.toString(), playController);
	}

	@Override
	public void execute() {
		this.playController.undo();
		super.execute();
	}

	@Override
	public boolean isActive() {
		return this.playController.undoable();
	}
	
}
