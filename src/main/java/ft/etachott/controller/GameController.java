package ft.etachott.controller;

import ft.etachott.service.GameService;
import ft.etachott.view.IGameView;

public abstract class GameController {
	public abstract void run();

	final private IGameView _gameView;
	final private GameService _gameService = new GameService();

	GameController(IGameView gameView) {
		_gameView = gameView;
	}

	public void handleInput(String input) throws InterruptedException {
		switch (input) {
			case "exit":
				quit();
			case "create":
				_gameView.createCharacterView();
				String[] rawCharacterInput = _gameView.getRawCharacterInput();
				_gameService.createCharacter();
				break ;
			case "choose":
				_gameView.chooseCharacterView();
				break ;
		}
	}

	public void quit() {
		_gameView.exitView();
		System.exit(0);
	}
}
