package ft.etachott.controller;

import ft.etachott.service.GameService;
import ft.etachott.view.IGameView;

public abstract class GameController {
	public abstract String getInput();
	public abstract void run();

	final private IGameView _gameView;
	final private GameService _gameService = new GameService();

	GameController(IGameView gameView) {
		_gameView = gameView;
	}

	public void handleInput(String input) {
		switch (input) {
			case "exit":
				quit();
			case "create":
				_gameView.createHeroView();
				_gameService.createHero();
				break ;
			case "choose":
				_gameView.chooseHeroView();
				break ;
		}
	}

	public void quit() {
		_gameView.exitView();
		System.exit(0);
	}
}
