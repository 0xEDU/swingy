package ft.etachott.controller;

import ft.etachott.component.InputValidator;
import ft.etachott.service.GameService;
import ft.etachott.view.IGameView;
import org.jline.reader.EndOfFileException;
import org.jline.reader.UserInterruptException;

public class GameController {
	final private IGameView _gameView;
	final private GameService _gameService = new GameService();

	public GameController(IGameView gameView) {
		_gameView = gameView;
	}

	public void run() {
		_gameView.initialView();
		while (true) {
			try {
				handleInput(_gameView.getInput());
			} catch (UserInterruptException ignored) {
			} catch (EndOfFileException e) {
				quit();
				System.exit(0);
			}
		}
	}

	public void quit() {
		_gameView.exitView();
		System.exit(0);
	}
	public void create() {
		_gameView.createCharacterView();
		String[] rawCharacterInput = _gameView.getRawCharacterInput();
		InputValidator.validateCharacterCreationInput(rawCharacterInput);
		_gameService.createCharacter(rawCharacterInput);
	}

	public void choose() {
		_gameView.chooseCharacterView();
	}

	public void handleInput(String input) {
		try {
			switch (input) {
				case "exit":
					quit();
				case "create":
					create();
					break ;
				case "choose":
					choose();
					break ;
			}
		} catch (IllegalArgumentException e) {
			_gameView.errorView(e.getMessage());
		}
	}

}
