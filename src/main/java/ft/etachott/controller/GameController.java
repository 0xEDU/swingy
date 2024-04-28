package ft.etachott.controller;

import ft.etachott.view.GameView;

public abstract class GameController {
	public abstract String getInput();
	public abstract void run();

	final private GameView _viewer;

	GameController(GameView viewer) {
		_viewer = viewer;
	}

	public void handleInput(String input) {
		switch (input) {
			case "exit":
				this.quit();
			case "create":
				_viewer.createHeroView();
				break ;
			case "choose":
				_viewer.chooseHeroView();
				break ;
		}
	}

	public void quit() {
		_viewer.exitView();
		System.exit(0);
	}
}
