package ft.etachott.builder;

import ft.etachott.controller.GameController;
import ft.etachott.view.IGameView;
import ft.etachott.service.GameService;

public class GameControllerBuilder {
    private IGameView _gameView;

    public GameControllerBuilder setGameView(IGameView gameView) {
        this._gameView = gameView;
        return this;
    }

    public GameController build() {
        if (_gameView == null) {
            throw new IllegalStateException("GameView cannot be null");
        }
        return new GameController(_gameView);
    }
}
