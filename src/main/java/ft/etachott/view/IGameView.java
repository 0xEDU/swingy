package ft.etachott.view;

import ft.etachott.model.Character;

import java.util.List;

public interface IGameView {
    void initialView();
    void createCharacterView();
    void chooseCharacterView(List<Character> characters);
    void exitView();
    String getInput();
    String[] getRawCharacterInput();
    void characterRoleView();
    void errorView(String error);
}
