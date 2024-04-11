package ft.etachott.controller;

import ft.etachott.view.GameView;

public abstract class GameController {
	public abstract String getInput();
	public abstract void run();

	public GameView viewer;

	GameController(GameView viewer) {
		this.viewer = viewer;
	}

	public void handleInput(String input) {
		System.out.println("input -> " + input);
	}
}
