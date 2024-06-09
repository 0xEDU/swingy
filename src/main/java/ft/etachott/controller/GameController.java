package ft.etachott.controller;

import ft.etachott.component.InputValidator;
import ft.etachott.enums.StateEnum;
import ft.etachott.model.Character;
import ft.etachott.service.GameService;
import ft.etachott.view.IGameView;
import jakarta.annotation.PostConstruct;
import org.jline.reader.EndOfFileException;
import org.jline.reader.UserInterruptException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.List;

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

	@PostConstruct
	public void run() {
		_gameView.initialView();
		while (true) {
			try {
				handleInput(_gameView.getInput());
			} catch (UserInterruptException ignored) {
			} catch (EndOfFileException e) {
				exit();
				break;
			}
		}
	}

	public void exit() {
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
		List<Character> characterList = _gameService.getCharacters();
		_gameView.chooseCharacterView(characterList);
		String rawId = _gameView.getRawCharacterId();
		InputValidator.validateCharacterId(rawId, characterList.size());
		_gameService.chooseCharacter(Integer.parseInt(rawId), characterList);
	}

	public void start() {
		_gameView.gameStartMessageView();
		_gameService.startGame();
	}

	public void handleInput(String input) {
		try {
			switch (input) {
				case "exit":
					exit();
				case "create":
					if (_gameService.getCurrentState() == StateEnum.SELECTING_CHARACTER) {
						create();
						break ;
					}
				case "choose":
					if (_gameService.getCurrentState() == StateEnum.SELECTING_CHARACTER) {
						choose();
						start();
						break;
					}
				default:
					_gameView.errorView("Invalid input: " + input);
					break;
			}
		} catch (IllegalArgumentException e) {
			_gameView.errorView(e.getMessage());
		}
	}

	public void setGameView(IGameView gameView) {
		this._gameView = gameView;
	}

}