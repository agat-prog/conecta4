package usantatecla.connect4.controllers;

import java.util.EnumMap;
import java.util.Map;

import usantatecla.connect4.models.Session;
import usantatecla.connect4.models.StateValue;

public class Logic {

    private Session session;
    private Map<StateValue, AcceptorController> acceptorControllers;

    public Logic() {
        this.session = new Session();
        this.acceptorControllers = new EnumMap<>(StateValue.class);
    }

    public AcceptorController getController() {
        return this.acceptorControllers.get(this.session.getValueState());
    }
}
