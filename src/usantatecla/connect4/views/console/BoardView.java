package usantatecla.connect4.views.console;

import usantatecla.connect4.controllers.Controller;
import usantatecla.connect4.models.Board;
import usantatecla.connect4.views.Message;
import usantatecla.utils.models.ConcreteCoordinate;
import usantatecla.utils.views.Console;

class BoardView {

    void write(Controller controller) {
        new MessageView().writeln(Message.HORIZONTAL_LINE);
        for (int i = Board.ROWS - 1; i >= 0; i--) {
            new MessageView().write(Message.VERTICAL_LINE);
            for (int j = Board.COLUMNS - 1; j >= 0 ; j--) {
                new ColorView().write(controller.getColor(new ConcreteCoordinate(i, j)));
                new MessageView().write(Message.VERTICAL_LINE);
            }
            Console.getInstance().writeln();
        }
        new MessageView().writeln(Message.HORIZONTAL_LINE);
    }
}
