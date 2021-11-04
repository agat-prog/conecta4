package usantatecla.connect4.distributed;

import usantatecla.connect4.Connect4;
import usantatecla.connect4.controllers.Logic;

public class Conecta4Client extends Connect4 {

	private LogicProxy logicProxy;
	
	@Override
	protected Logic createLogic() {
		this.logicProxy = new LogicProxy();
		return this.logicProxy;
	}

	@Override
	protected void play() {
		super.play();
		this.logicProxy.close();
	}
	
	public static void main(String[] args) {
		new Conecta4Client().play();
	}
}
