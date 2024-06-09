package ft.etachott.view;

import ft.etachott.model.Character;

import java.util.List;

public interface IGameView {
    void initialView();
    void createCharacterView();
    void chooseCharacterView(List<Character> characters) throws NumberFormatException;
    void exitView();
    String getInput();
    String[] getRawCharacterInput();
    String getRawCharacterId();
    void characterRoleView();
    void errorView(String error);
    void gameStartMessageView();
}
