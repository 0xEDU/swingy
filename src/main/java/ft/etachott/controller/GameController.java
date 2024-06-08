package ft.etachott.controller;

import ft.etachott.component.InputValidator;
import ft.etachott.service.GameService;
import ft.etachott.view.IGameView;
import jakarta.annotation.PostConstruct;
import org.jline.reader.EndOfFileException;
import org.jline.reader.UserInterruptException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {
	private IGameView _gameView;
	final private GameService _gameService;
	final private ApplicationContext _applicationContext;

	@Autowired
	public GameController(IGameView gameView, GameService gameService, ApplicationContext applicationContext) {
		this._gameView = gameView;
		this._gameService = gameService;
		this._applicationContext = applicationContext;
	}

	public void setGameView(IGameView gameView) {
		this._gameView = gameView;
	}

	@PostConstruct
	public void run() {
		_gameView.initialView();
		while (true) {
			try {
				handleInput(_gameView.getInput());
			} catch (UserInterruptException ignored) {
			} catch (EndOfFileException e) {
				quit();
				break;
			}
		}
	}

	public void quit() {
		_gameView.exitView();
		int exitCode = SpringApplication.exit(_applicationContext, () -> 0);
		System.exit(exitCode);
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
