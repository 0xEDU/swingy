package ft.etachott.service;

import ft.etachott.enums.StateEnum;
import org.springframework.stereotype.Service;

@Service
public class StateMachineService {
    private StateEnum _currentState = StateEnum.SELECTING_CHARACTER;

    public StateEnum getCurrentState() {
        return _currentState;
    }

    public void nextState() {
        switch (_currentState) {
            case SELECTING_CHARACTER:
                _currentState = StateEnum.PLAYING_MAP;
                break;
            case PLAYING_MAP:
                _currentState = StateEnum.POST_GAME;
                break;
            case POST_GAME:
                _currentState = StateEnum.SELECTING_CHARACTER;
                break;
        }
    }
}
