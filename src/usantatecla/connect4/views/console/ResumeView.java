package usantatecla.connect4.views.console;

import usantatecla.connect4.controllers.ResumeController;
import usantatecla.connect4.views.Message;
import usantatecla.utils.views.YesNoDialog;

class ResumeView {

    boolean interact(ResumeController resumeController) {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        if (isResumed.isAffirmative()) {
            resumeController.reset();
        } else {
            resumeController.nextState();
        }
        return isResumed.isAffirmative();
    }

}
