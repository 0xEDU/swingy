package ft.etachott.view;

public interface IGameView {
    void initialView();
    void createHeroView();
    void chooseHeroView();
    void exitView();
    String getInput();
    String[] getRawHeroInput() throws InterruptedException;
}
