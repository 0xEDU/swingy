package ft.etachott.view;

public interface IGameView {
    void initialView();
    void createCharacterView();
    void chooseCharacterView();
    void exitView();
    String getInput();
    String[] getRawCharacterInput();
    void characterClassView();
    void errorView(String error);
}
