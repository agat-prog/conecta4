package usantatecla.connect4.views;

import usantatecla.connect4.controllers.AcceptorController;
import usantatecla.connect4.controllers.ControllersVisitor;
import usantatecla.connect4.controllers.PlayController;
import usantatecla.connect4.controllers.ResumeController;
import usantatecla.connect4.controllers.StartController;
import usantatecla.connect4.views.console.PlayView;
import usantatecla.connect4.views.console.ResumeView;
import usantatecla.connect4.views.console.StartView;

public class View implements ControllersVisitor {
	 
		private StartView startView;

		private PlayView playView;

		private ResumeView resumeView;

		public View() {
			this.startView = new StartView();
			this.playView = new PlayView();
			this.resumeView = new ResumeView();
		}

		public void interact(AcceptorController acceptorController) {
			acceptorController.accept(this);
		}

		
		public void visit(StartController startController) {
			this.startView.interact(startController);
		}

		
		public void visit(PlayController playController) {
			this.playView.interact(playController);
		}

		
		public void visit(ResumeController resumeController) {
			this.resumeView.interact(resumeController);
		}
}
