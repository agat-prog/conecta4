package usantatecla.connect4.controllers;

import usantatecla.connect4.models.Session;

public class NullController extends Controller implements AcceptorController {

	NullController(Session session) {
		super(session);
	}

	private static NullController nullController;

	public static AcceptorController getInstance() {
		if (NullController.nullController == null) {
			NullController.nullController = new NullController(null);
		}
		return NullController.nullController;
	}

	@Override
	public void accept(ControllersVisitor controllerVisitor) {
	}

	@Override
	public boolean isNull() {
		return true;
	}
}
