package usantatecla.connect4.views.console;

import usantatecla.connect4.types.Error;
import usantatecla.utils.views.Console;

class ErrorView extends usantatecla.connect4.views.ErrorView {

    @Override
    public void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(ErrorView.MESSAGES[error.ordinal()]);
        }
    }

}
