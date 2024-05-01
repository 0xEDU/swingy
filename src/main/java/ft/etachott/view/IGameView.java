package ft.etachott.view;

public interface IGameView {
    void initialView();
    void createCharacterView();
    void chooseCharacterView();
    void exitView();
    String getInput();
    String[] getRawCharacterInput();
    void characterRoleView();
    void errorView(String error);
}
