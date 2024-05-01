package ft.etachott.controller;

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
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
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
