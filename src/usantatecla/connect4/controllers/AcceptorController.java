package usantatecla.connect4.controllers;

public abstract class AcceptorController extends Controller{

	AcceptorController(Session session) {
		super(session);
    }
    
    public abstract boolean isNull();

	public abstract void accept(ControllersVisitor controllerVisitor);
}