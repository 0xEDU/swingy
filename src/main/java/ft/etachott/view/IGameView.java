package ft.etachott.view;

public interface IGameView {
    void initialView();
    void createCharacterView();
    void chooseCharacterView();
    void exitView();
    String getInput();
    String[] getRawCharacterInput() throws InterruptedException;
    void characterClassView();
}
