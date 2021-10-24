package usantatecla.connect4.views.console;

import usantatecla.connect4.controllers.ResumeController;
import usantatecla.connect4.views.Message;
import usantatecla.utils.views.YesNoDialog;

public class ResumeView {

    public void interact(ResumeController resumeController) {
        resumeController.resume(new YesNoDialog().read(Message.RESUME.toString()));
    }

}
