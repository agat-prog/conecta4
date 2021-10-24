package usantatecla.connect4.controllers;

public interface AcceptorController {

	void accept(ControllersVisitor controllerVisitor);
    boolean isNull();
}
