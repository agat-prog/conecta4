package usantatecla.connect4.controllers;

import java.util.EnumMap;
import java.util.Map;

import usantatecla.connect4.models.Session;
import usantatecla.connect4.models.StateValue;

public class Logic {

    private Session session;
    private Map<StateValue, AcceptorController> controllers;

    public Logic() {
        this.session = new Session();
        this.controllers = new EnumMap<>(StateValue.class);
        this.controllers.put(StateValue.INITIAL, new StartController(this.session));
        this.controllers.put(StateValue.IN_GAME, new PlayController(this.session));
        this.controllers.put(StateValue.RESUME, new ResumeController(this.session));
        this.controllers.put(StateValue.EXIT, NullController.getInstance()); 
    }

    public AcceptorController getController() {
        return this.controllers.get(this.session.getValueState());
    }
}
